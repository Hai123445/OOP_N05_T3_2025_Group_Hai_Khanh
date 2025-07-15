import java.util.ArrayList;
import java.util.Scanner;
public class testGiaodich {
 static Scanner scanner = new Scanner(System.in);
 static ArrayList<Giaodich> dsGiaodich = new ArrayList<>();
    public static void menu(){
        int n;
        do{
        System.out.println("1.Create");
        System.out.println("2.Read");
        System.out.println("3.Update");
        System.out.println("4.Delete");
        n = scanner.nextInt();
        scanner.nextLine();  
        switch(n){
            case 1 -> themGiaodich();
            case 2 -> docGiaodich();
            case 3 -> suaGiaodich();
            case 4 -> xoaGiaodich();
            default -> System.out.println("Lua chon khong hop le");
        }
     }
       while(n != 0);
    }
    public static void themGiaodich(){
        System.out.print("Nhap ma giao dich");
        String mgd = scanner.nextLine();
        System.out.print("Nhap ngay giao dich");
        String ngd = scanner.nextLine();
        System.out.print("Nhap nhan vien giao dich");
        String nvgd = scanner.nextLine();
        System.out.print("Nhap tong tien");
        Double tt = scanner.nextDouble();
        System.out.print("Nhap so luong sp");
        int tsp = scanner.nextInt();
        scanner.nextLine();
        Giaodich gd = new Giaodich(mgd,ngd,nvgd,tt,tsp);
        dsGiaodich.add(gd);
        System.out.println("Them giao dich thanh cong");
   }
   public static void docGiaodich(){
     gd.hienthi();
   }
}

