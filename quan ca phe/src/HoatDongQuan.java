import java.util.ArrayList;
import java.util.Scanner;

import com.example.servingwebcontent.Giaodich;
public class HoatDongQuan {
    public Nhanvien nv;
    public KhachHang kh;
    public Giaodich gd;
    public SanPham sp;

    public HoatDongQuan(Nhanvien nv, KhachHang kh, Giaodich gd,SanPham sp) {
        this.nv= nv;
        this.kh = kh;
        this.gd = gd;
        this.sp = sp;
    }
    
    static Scanner scanner = new Scanner(System.in); 
    static ArrayList<Giaodich>  dstrongngay = new ArrayList<>();
    public static void quanly(){
     int n;
    do{
        System.out.println("====== QUẢN LÝ HOẠT ĐỘNG QUÁN COFFE ======");
        System.out.println("1.Quản lý Khách Hàng");
        System.out.println("2.Quản lý Sản Phẩm");
        System.out.println("3.Quản lý Nhân Viên");
        System.out.println("4.Quản lý Giao Dịch");
        System.out.println("5.Thoát");
        System.out.println("Chọn chức năng: ");
        n = scanner.nextInt();
        scanner.nextLine();
        switch (n) {
            case 1: testKhachhang.testkh(); break;
            case 2: testSanPham.test(); break;
            case 3: testNhanvien.menu(); break;
            case 4: testGiaodich.testgd(); break;
            case 5 : System.out.println("Thoát menu"); break;
            default : System.out.println("Lựa chọn không hợp lệ"); break;
            }
      }
        while (n != 5);
            
         }
    public static void hienthigdtrongngay(){
   String ngaycantim = scanner.nextLine();
   String nvcantim = scanner.nextLine();
   dstrongngay.clear();
   for(Giaodich gd : Giaodich.dsGiaodich) {
       if(gd.getNgd().equals(ngaycantim)&&gd.getNvgd().equals(nvcantim)){
          dstrongngay.add(gd);
       }
       }
       if(dstrongngay.isEmpty()){
        System.out.println("Không có giao dịch nào");
       }
       else{
        System.out.println("Danh Sách Giao Dịch");
        for(Giaodich gd : dstrongngay){
               gd.hienthi();
        }
       }
   }
   public static void timKiemTheoTen(ArrayList<SanPham> danhSachSanPham, Scanner sc) {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String tenCanTim = sc.nextLine().toLowerCase(); // nhập tên cần tìm và chuyển về chữ thường

        boolean timThay = false;

        for (SanPham sp : danhSachSanPham) {
            if (sp.getTenSp().toLowerCase().contains(tenCanTim)) {
                System.out.println("Tìm thấy sản phẩm:");
                sp.inThongTin(); // gọi hàm hiển thị sản phẩm
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy sản phẩm nào với tên \"" + tenCanTim + "\"");
        }
    }
}
