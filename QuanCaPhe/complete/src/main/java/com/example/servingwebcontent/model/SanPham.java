package com.example.demo.model;

public class SanPham {
    private int id;
    private String ten;
    private double gia;
    private String mota;

    public SanPham() {}

    public SanPham(int id, String ten, double gia, String mota) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.mota = mota;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public double getGia() {
        return gia;
    }
    public void setGia(double gia) {
        this.gia = gia;
    }
    public String getMota() {
        return mota;
    }
    public void setMota(String mota) {
        this.mota = mota;
    }
} 
