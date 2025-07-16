public class Giaodich {

    //bien mieu ta cho giao dich
    String MaGiaoDich;
    String NgayThangNamGiaoDich;
    String NhanVienGiaoDich;
    double TongTien;
    int TongSoSp;

//phuong thuc hoat dong
public Giaodich(String mgd,String ngd,String nvgd,double tt,int tsp){
    this.MaGiaoDich = mgd;
    this.NgayThangNamGiaoDich = ngd;
    this.NhanVienGiaoDich = nvgd;
    this.TongTien = tt;
    this.TongSoSp = tsp; 
}
public String getMgd(){
    return MaGiaoDich;
    }
    public String getNgd(){
        return NgayThangNamGiaoDich;
    }
    public String getNvgd(){
        return NhanVienGiaoDich;
    }
    public double getTt(){
        return TongTien;
    }
    public int getTsp(){
        return TongSoSp;
    }
    public void setMgd(String mgd){
         this.MaGiaoDich = mgd;
    }
    public void setNgd(String ngd){
        this.NgayThangNamGiaoDich = ngd;
    }
    public void setNvgd(String nvgd){
        this.NhanVienGiaoDich = nvgd;
    }
    public void setTt(double tt){
        this.TongTien = tt;
    }
    public void setTsp(int tsp){
        this.TongSoSp = tsp;
    }
//Read
public void hienthi(){
    System.out.println("Ma giao dich :"  + MaGiaoDich);
    System.out.println("Ngay thang nam giao dich:" + NgayThangNamGiaoDich);
    System.out.println("Gio giao dich:" + NhanVienGiaoDich);
    System.out.println("Tong tien: " + TongTien);
    System.out.println("Tong so san pham : " + TongSoSp);
}
}
