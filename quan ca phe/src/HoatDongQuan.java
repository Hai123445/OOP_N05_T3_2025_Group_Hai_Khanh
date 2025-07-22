import java.util.ArrayList;
import java.util.Scanner;
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
    static ArrayList<Giaodich> dsGiaodich = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in); 
    static ArrayList<Giaodich>  dstrongngay = new ArrayList<>();
    public static void hienthigdtrongngay(){
   String ngaycantim = scanner.nextLine();
   String nvcantim = scanner.nextLine();
   dstrongngay.clear();
   for(Giaodich gd : dsGiaodich) {
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
