package com.example.servingwebcontent.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nhân viên
    @ManyToOne
    @JoinColumn(name = "nhanvien_id", nullable = false)
    private NhanVien nhanVien;

    // Món ăn
    @ManyToOne
    @JoinColumn(name = "menuitem_id", nullable = false)
    private MenuItem menuItem;

    private int quantity;
    private LocalDate orderDate = LocalDate.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public NhanVien getNhanVien() { return nhanVien; }
    public void setNhanVien(NhanVien nhanVien) { this.nhanVien = nhanVien; }

    public MenuItem getMenuItem() { return menuItem; }
    public void setMenuItem(MenuItem menuItem) { this.menuItem = menuItem; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }
}
