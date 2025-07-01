public class Giaodich {

    //bien mieu ta cho giao dich
    String MaGiaoDich;
    String NgayThangNamGiaoDich;
    String GioGiaoDich;
    double TongTien;


    //phuong thuc hoat dong
public Giaodich(String mgd,String ngd,String ggd,double tt){
    this.MaGiaoDich = mgd;
    this.NgayThangNamGiaoDich = ngd;
    this.GioGiaoDich = ggd;
    this.TongTien = tt; 
}
public void hienthi(){
    System.out.println("Ma giao dich :"  + MaGiaoDich);
    System.out.println("Ngay thang nam giao dich:" + NgayThangNamGiaoDich);
    System.out.println("Gio giao dich:" + GioGiaoDich);
    System.out.println("Tong tien: " + TongTien);
}
}
