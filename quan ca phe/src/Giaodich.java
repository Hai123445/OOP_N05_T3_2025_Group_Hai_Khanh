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
    //create
    public static void themGiaodich(){
        System.out.print("Nhap ma giao dich: ");
        String mgd = scanner.nextLine();
        System.out.print("Nhap ngay giao dich: ");
        String ngd = scanner.nextLine();
        System.out.print("Nhap nhan vien giao dich: ");
        String nvgd = scanner.nextLine();
        System.out.print("Nhap tong tien: ");
        Double tt = scanner.nextDouble();
        System.out.print("Nhap so luong sp: ");
        int tsp = scanner.nextInt();
        scanner.nextLine();
        Giaodich gd = new Giaodich(mgd,ngd,nvgd,tt,tsp);
        dsGiaodich.add(gd);
        System.out.println("Them giao dich thanh cong");
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
        if(gd.getMgd().equalsIgnoreCase(macansua)){
            System.out.print("Nhap ma: ");
            gd.setMgd(scanner.nextLine());
            System.out.print("Nhap ngay: ");
            gd.setNgd(scanner.nextLine());
            System.out.print("Nhap nhan vien: ");
            gd.setNvgd(scanner.nextLine());
            System.out.print("nhap tong tien: ");
            gd.setTt(scanner.nextDouble());
            System.out.print("Nhap tong sp: ");
            gd.setTsp(scanner.nextInt());
            scanner.nextLine();
            return; 
        }
        System.out.println("khong tim thay ma GD");
    }
   }
   //delete
   public static void xoaGiaodich(){
    String macanxoa = scanner.nextLine();
    for(Giaodich gd : dsGiaodich){
        if(gd.getMgd().equals(macanxoa)){
                dsGiaodich.remove(gd);
              return;
    }
    System.err.println("khong tim thay ma GD");
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
