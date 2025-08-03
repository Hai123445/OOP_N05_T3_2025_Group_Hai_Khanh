import java.util.Scanner;
public class testGiaodich {
 static Scanner scanner = new Scanner(System.in);
   public static void testgd(){
        int n;
        do{
        System.out.println("====== QUẢN LÝ GIAO DỊCH ======");  
        System.out.println("1.Thêm giao dịch");
        System.out.println("2.Hiển thị giao dịch");
        System.out.println("3.Cập nhật giao dịch");
        System.out.println("4.Xóa giao dịch");
        System.out.println("5.Hiển thị ds trong ngày theo nv");
        System.out.println("0.Thoát");
        System.out.print("Chọn chức năng: ");
        n = scanner.nextInt();
        scanner.nextLine();  
        switch(n){
            case 1 : Giaodich.themGiaodich();break;
            case 2 : Giaodich.docGiaodich(); break;
            case 3 : Giaodich.suaGiaodich(); break;
            case 4 : Giaodich.xoaGiaodich(); break;
            case 5 : HoatDongQuan.hienthigdtrongngay(); break;
            case 0 : System.out.println("Thoát menu"); break;
            default : System.out.println("Lựa chọn không hợp lệ!"); break;
        }
     }
       while(n != 0);
    }

    
}