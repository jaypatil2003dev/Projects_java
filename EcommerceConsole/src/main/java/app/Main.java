package com.example.app;

import com.example.dao.ProductDAO;
import com.example.model.Product;
import com.example.service.CartService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductDAO pdao = new ProductDAO();
        CartService cart = new CartService();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n1) List products  2) Add to cart  3) View cart  4) Checkout  0) Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    List<Product> products = pdao.getAll();
                    products.forEach(System.out::println);
                    break;
                case "2":
                    System.out.print("Product id: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Quantity: ");
                    int qty = Integer.parseInt(sc.nextLine());
                    cart.addToCart(id, qty);
                    System.out.println("Added to cart.");
                    break;
                case "3":
                    cart.printCart(pdao);
                    break;
                case "4":
                    if (cart.checkout(pdao)) System.out.println("Checkout success.");
                    else System.out.println("Checkout failed.");
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
