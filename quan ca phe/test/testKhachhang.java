import java.util.ArrayList;
import java.util.Scanner;
public class testKhachhang {
static Scanner scanner = new Scanner(System.in);
 static ArrayList<KhachHang> dsKhachhang = new ArrayList<>();
    public static void testkh(){
        int n;
        do{
        System.out.println("1.Create");
        System.out.println("2.Read");
        System.out.println("3.Update");
        System.out.println("4.Delete");
        System.out.println("0.Thoat");
        n = scanner.nextInt();
        scanner.nextLine();  
        switch(n){
            case 1 : themKhachhang();break;
            case 2 : docKhachhang(); break;
            case 3 : suaKhachhang(); break;
            case 4 : xoaKhachhang(); break;
            case 0 : System.out.println("Thoat menu"); break;
            default : System.out.println("Lua chon khong hop le"); break;
        }
     }
       while(n != 0);
    }
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
}
