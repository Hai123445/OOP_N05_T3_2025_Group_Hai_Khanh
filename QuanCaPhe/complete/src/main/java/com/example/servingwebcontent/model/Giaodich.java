package com.example.servingwebcontent.model;
import java.util.ArrayList;
import java.util.Scanner;
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
    static Scanner scanner = new Scanner(System.in);
 static ArrayList<Giaodich> dsGiaodich = new ArrayList<>();
 public static void themGiaodich(){
        System.out.print("Nhập mã giao dịch: ");
        String mgd = scanner.nextLine();
        System.out.print("Nhập ngày giao dich: ");
        String ngd = scanner.nextLine();
        System.out.print("Nhập nhân viên giao dịch: ");
        String nvgd = scanner.nextLine();
        System.out.print("Nhập tổng tiền: ");
        Double tt = scanner.nextDouble();
        System.out.print("Nhập số lượng sp: ");
        int tsp = scanner.nextInt();
        scanner.nextLine();
        Giaodich gd = new Giaodich(mgd,ngd,nvgd,tt,tsp);
        dsGiaodich.add(gd);
        System.out.println("Thêm giao dịch thành công");
   }
   //read
   public static void docGiaodich(){
    for (Giaodich gd : dsGiaodich){
     gd.hienthi();
   }
}
//update
   public static void suaGiaodich(){
    String macansua = scanner.nextLine();
    for(Giaodich gd : dsGiaodich){
        if(gd.getMgd().equals(macansua)){
            System.out.print("Nhap mã mới: ");
            gd.setMgd(scanner.nextLine());
            System.out.print("Nhap ngày mới: ");
            gd.setNgd(scanner.nextLine());
            System.out.print("Nhap nhân viên mới: ");
            gd.setNvgd(scanner.nextLine());
            System.out.print("Nhập tổng tiền mới: ");
            gd.setTt(scanner.nextDouble());
            System.out.print("Nhập tổng sp mới: ");
            gd.setTsp(scanner.nextInt());
            scanner.nextLine();
            break; 
        }
        System.out.println("Không tìm thấy mã GD");
    }
   }
   //delete
   public static void xoaGiaodich(){
    String macanxoa = scanner.nextLine();
    for(Giaodich gd : dsGiaodich){
        if(gd.getMgd().equals(macanxoa)){
                dsGiaodich.remove(gd);
              break;
    }
    System.err.println("Không tìm thấy mã GD");
}
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

