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
        System.out.println("0.Thoat");
        n = scanner.nextInt();
        scanner.nextLine();  
        switch(n){
            case 1 : 
            themGiaodich();
            break;
            case 2 : docGiaodich(); break;
            case 3 : suaGiaodich(); break;
            case 4 : xoaGiaodich(); break;
            case 0 : System.out.println("Thoat menu"); break;
            default : System.out.println("Lua chon khong hop le"); break;
        }
     }
       while(n != 0);
    }
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
}