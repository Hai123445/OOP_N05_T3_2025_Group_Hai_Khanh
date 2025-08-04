import java.util.Scanner;
import com.example.servingwebcontent.model.KhachHang;
public class testKhachhang {
static Scanner scanner = new Scanner(System.in);
   public static void testkh(){
        int n;
        do{
        System.out.println("====== QUẢN LÝ KHÁCH HÀNG ======");
        System.out.println("1.Thêm khách hàng");
        System.out.println("2.Danh sách khách hàng");
        System.out.println("3.Chỉnh thông tin khách hàng");
        System.out.println("4.Xóa khách hàng");
        System.out.println("0.Thoát");
        System.out.print("Chọn chức năng: ");
        n = scanner.nextInt();
        scanner.nextLine();  
        switch(n){
            case 1 : KhachHang.themKhachhang();break;
            case 2 : KhachHang.docKhachhang(); break;
            case 3 : KhachHang.suaKhachhang(); break;
            case 4 : KhachHang.xoaKhachhang(); break;
            case 0 : System.out.println("Thoát menu"); break;
            default : System.out.println("Lựa chọn không hợp lệ!"); break;
        }
     }
       while(n != 0);
    }
}