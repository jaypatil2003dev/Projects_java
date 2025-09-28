package com.example.model;

import java.time.LocalDateTime;

public class Order {
    private int id;
    private double total;
    private LocalDateTime createdAt;

    public Order() {}

    public Order(int id, double total, LocalDateTime createdAt) {
        this.id = id; this.total = total; this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
