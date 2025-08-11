package com.example.servingwebcontent.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maDonHang;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private MenuItem product;

    @ManyToOne
    @JoinColumn(name = "nhanvien_id", nullable = false)
    private NhanVien nhanVien;

    private int soLuong;
    private LocalDate orderDate;

    // Getters & Setters
    public Long getMaDonHang() {
        return maDonHang;
    }
    public void setMaDonHang(Long maDonHang) {
        this.maDonHang = maDonHang;
    }

    public MenuItem getProduct() {
        return product;
    }
    public void setProduct(MenuItem product) {
        this.product = product;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }
    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
