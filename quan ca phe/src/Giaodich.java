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
//Read
public void hienthi(){
    System.out.println("Ma giao dich :"  + MaGiaoDich);
    System.out.println("Ngay thang nam giao dich:" + NgayThangNamGiaoDich);
    System.out.println("Gio giao dich:" + NhanVienGiaoDich);
    System.out.println("Tong tien: " + TongTien);
    System.out.println("Tong so san pham : " + TongSoSp);
}
}
//Update 
public void suaGd(String mgdMoi,String ngdMoi,String nvgdMoi,double ttMoi,int tspMoi){
    this.MaGiaoDich = mgdMoi;
    this.NgayThangNamGiaoDich = ngdMoi;
    this.NhanVienGiaoDich = nvgdMoi;
    this.TongTien = ttMoi;
    this.TongSoSp = tspMoi; 
}
//Delete
public void xoaGd(){
    this.MaGiaoDich = "";
    this.NgayThangNamGiaoDich = "";
    this.NhanVienGiaoDich = "";
    this.TongTien = 0;
    this.TongSoSp = 0;
}