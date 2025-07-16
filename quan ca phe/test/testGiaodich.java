import java.util.Scanner;
public class testGiaodich {
 static Scanner scanner = new Scanner(System.in);
   public static void testgd(){
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
            case 1 : Giaodich.themGiaodich();break;
            case 2 : Giaodich.docGiaodich(); break;
            case 3 : Giaodich.suaGiaodich(); break;
            case 4 : Giaodich.xoaGiaodich(); break;
            case 0 : System.out.println("Thoat menu"); break;
            default : System.out.println("Lua chon khong hop le"); break;
        }
     }
       while(n != 0);
    }
}