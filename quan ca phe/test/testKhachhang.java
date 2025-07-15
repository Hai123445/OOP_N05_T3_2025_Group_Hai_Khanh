import java.util.ArrayList;
import java.util.Scanner;
public class testKhachhang {
static Scanner scanner = new Scanner(System.in);
 static ArrayList<Giaodich> dsKhachhang = new ArrayList<>();
    public static void menu(){
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
  }
    
}
