package com.example.service;

import com.example.dao.ProductDAO;
import com.example.dao.Database;
import com.example.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.Map.Entry;

public class CartService {
    private final Map<Integer, Integer> cart = new HashMap<>();

    public void addToCart(int productId, int qty) {
        cart.put(productId, cart.getOrDefault(productId, 0) + qty);
    }

    public void printCart(ProductDAO pdao) {
        if (cart.isEmpty()) { System.out.println("Cart empty."); return; }
        double total = 0;
        for (Entry<Integer, Integer> e : cart.entrySet()) {
            Product p = pdao.findById(e.getKey());
            if (p != null) {
                double line = p.getPrice() * e.getValue();
                total += line;
                System.out.printf("%s x %d = ₹%.2f%n", p.getName(), e.getValue(), line);
            }
        }
        System.out.printf("Total = ₹%.2f%n", total);
    }

    public boolean checkout(ProductDAO pdao) {
        if (cart.isEmpty()) return false;

        try (Connection conn = Database.getConnection()) {
            try {
                conn.setAutoCommit(false);

                // validate stock
                for (Entry<Integer, Integer> e : cart.entrySet()) {
                    Product p = pdao.findById(e.getKey());
                    if (p == null || p.getStock() < e.getValue()) {
                        throw new RuntimeException("Out of stock for product id: " + e.getKey());
                    }
                }

                // create order
                String insertOrder = "INSERT INTO orders(total) VALUES(?) RETURNING id";
                double total = cart.entrySet().stream()
                        .mapToDouble(en -> pdao.findById(en.getKey()).getPrice() * en.getValue()).sum();

                int orderId;
                try (PreparedStatement ps = conn.prepareStatement(insertOrder)) {
                    ps.setDouble(1, total);
                    try (ResultSet rs = ps.executeQuery()) {
                        rs.next();
                        orderId = rs.getInt(1);
                    }
                }

                // insert items and reduce stock
                String insertItem = "INSERT INTO order_items(order_id, product_id, qty, price) VALUES(?,?,?,?)";
                String updateStock = "UPDATE products SET stock = stock - ? WHERE id = ?";

                try (PreparedStatement psItem = conn.prepareStatement(insertItem);
                     PreparedStatement psStock = conn.prepareStatement(updateStock)) {

                    for (Entry<Integer, Integer> e : cart.entrySet()) {
                        Product p = pdao.findById(e.getKey());
                        int qty = e.getValue();

                        psItem.setInt(1, orderId);
                        psItem.setInt(2, p.getId());
                        psItem.setInt(3, qty);
                        psItem.setDouble(4, p.getPrice());
                        psItem.executeUpdate();

                        psStock.setInt(1, qty);
                        psStock.setInt(2, p.getId());
                        psStock.executeUpdate();
                    }
                }

                conn.commit();
                cart.clear();
                System.out.println("Order created successfully. Order id: " + orderId);
                return true;
            } catch (Exception ex) {
                conn.rollback();
                throw ex;
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
