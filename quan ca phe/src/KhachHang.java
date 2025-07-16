import java.util.ArrayList;
import java.util.Scanner;
public class KhachHang{
    String MaKh;
    String TenKh;
    String sdt;



    // phuong thuc dac biet vi cung ten voi Lop --> Constructor
   public KhachHang(String maKh, String tenKh, String sdt) {
        this.MaKh = maKh;
        this.TenKh = tenKh;
        this.sdt = sdt;
}
public String getMakh(){
    return MaKh;
}
public void setMakh(String maKh){
    this.MaKh = maKh;
}
public void setTenkh(String tenKh){
    this.TenKh = tenKh;
}
public void setSdt(String sdt){
    this.sdt = sdt;
}
static Scanner scanner = new Scanner(System.in);
 static ArrayList<KhachHang> dsKhachhang = new ArrayList<>();
public static void themKhachhang(){
     System.out.print("Nhap ma KH");
     String makh = scanner.nextLine(); 
     System.out.print("Nhap ten KH");
     String tenKh = scanner.nextLine();
     System.out.print("Nhap Sdt");
     String sdt = scanner.nextLine();
     KhachHang kh = new KhachHang(makh,tenKh,sdt);
     dsKhachhang.add(kh);
  }
  public static void docKhachhang(){
   for(KhachHang kh : dsKhachhang ){
      kh.hienthi();
   };
  }
public static void suaKhachhang(){
   String macansua = scanner.nextLine();
   for(KhachHang kh : dsKhachhang){
      if(kh.getMakh().equals(macansua)){
         System.out.print("Nhap ma moi");
         kh.setMakh(scanner.nextLine());
         System.out.print("Nhap ten moi");
         kh.setTenkh(scanner.nextLine());
         System.out.print("Nhap sdt moi");
         kh.setSdt(scanner.nextLine());
      }
      System.out.println("khong tim thay ma");
   }
  }
public static void xoaKhachhang(){
      String macanxoa = scanner.nextLine();
      for(KhachHang kh : dsKhachhang){
         if(kh.getMakh().equals(macanxoa)){
            dsKhachhang.remove(kh);
            break;
         }
         System.out.println("Khong tim thay ma");
      }
  }   
public void hienthi(){
    System.out.println("Ten khach hang: " + TenKh);
    System.out.println("Ma khach hang:" + MaKh);
    System.out.println("sdt:" + sdt);
}



}
