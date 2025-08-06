
package com.example.servingwebcontent.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SanPham{
    @Id
    public String maSp;
    public String tenSp;
    public int giaSp;
    public String mota;
// Constructor
    public SanPham(String maSp, String tenSp, int giaSp,String mota) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.giaSp = giaSp;
        this.mota = mota;
    }

    // Getters and Setters
    public String getMaSp() {
        return maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public int getGiaSp() {
        return giaSp;
    }
    public String getmota(){
        return mota;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public void setGiaSp(int giaSp) {
        this.giaSp = giaSp;
    }
    public void setmota(String mota){
        this.mota = mota;
    }
}
