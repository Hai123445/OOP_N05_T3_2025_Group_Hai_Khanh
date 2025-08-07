package com.example.servingwebcontent.model;

import jakarta.persistence.*;

@Entity
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String status;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public void setStatus(String status) {
        if (status == null || (!"Còn".equalsIgnoreCase(status) && !"Hết".equalsIgnoreCase(status))) {
            throw new IllegalArgumentException("Trạng thái phải là 'Còn' hoặc 'Hết'");
        }
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

}