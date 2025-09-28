package com.example.model;

public class OrderItem {
    private int id;
    private int orderId;
    private int productId;
    private int qty;
    private double price;

    public OrderItem() {}

    public OrderItem(int id, int orderId, int productId, int qty, double price) {
        this.id = id; this.orderId = orderId;
        this.productId = productId; this.qty = qty; this.price = price;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
