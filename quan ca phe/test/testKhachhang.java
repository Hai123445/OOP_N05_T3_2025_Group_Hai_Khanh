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
            case 1 : KhachHang.themKhachhang();break;
            case 2 : KhachHang.docKhachhang(); break;
            case 3 : KhachHang.suaKhachhang(); break;
            case 4 : KhachHang.xoaKhachhang(); break;
            case 0 : System.out.println("Thoat menu"); break;
            default : System.out.println("Lua chon khong hop le"); break;
        }
     }
       while(n != 0);
    }
   