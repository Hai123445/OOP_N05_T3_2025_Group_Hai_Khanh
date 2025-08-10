package com.example.servingwebcontent.model;
import java.util.ArrayList;
import java.util.Scanner;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Nhanvien {
    @Id
    private String maNv;
    private String tenNv;
    private String sdt;

    public Nhanvien() {
    }

    public Nhanvien(String maNv, String tenNv, String sdt) {
        this.maNv = maNv;
        this.tenNv = tenNv;
        this.sdt = sdt;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}