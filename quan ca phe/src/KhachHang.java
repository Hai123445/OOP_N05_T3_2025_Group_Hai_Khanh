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
     System.out.print("Nhập mã KH");
     String makh = scanner.nextLine(); 
     System.out.print("Nhập tên KH");
     String tenKh = scanner.nextLine();
     System.out.print("Nhập Sdt");
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
         System.out.print("Nhập mã mới");
         kh.setMakh(scanner.nextLine());
         System.out.print("Nhập tên mới");
         kh.setTenkh(scanner.nextLine());
         System.out.print("Nhập sdt mới");
         kh.setSdt(scanner.nextLine());
      }
      System.out.println("không tìm thấy mã");
   }
  }
public static void xoaKhachhang(){
      String macanxoa = scanner.nextLine();
      for(KhachHang kh : dsKhachhang){
         if(kh.getMakh().equals(macanxoa)){
            dsKhachhang.remove(kh);
            break;
         }
         System.out.println("không tìm thấy mã");
      }
  }   
public void hienthi(){
    System.out.println("Ten khach hang: " + TenKh);
    System.out.println("Ma khach hang:" + MaKh);
    System.out.println("sdt:" + sdt);
}
}
