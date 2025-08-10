package com.example.servingwebcontent.model;

public class NhanVien {
    private String maNv;
    private String tenNv;
    private String sdt;
    private String diaChi;

    public NhanVien(String maNv, String tenNv, String sdt, String diaChi) {
        this.maNv = maNv;
        this.tenNv = tenNv;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public String getMaNv() { return maNv; }
    public String getTenNv() { return tenNv; }
    public String getSdt() { return sdt; }
    public String getDiaChi() { return diaChi; }

    public void setMaNv(String maNv) { this.maNv = maNv; }
    public void setTenNv(String tenNv) { this.tenNv = tenNv; }
    public void setSdt(String sdt) { this.sdt = sdt; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
}
