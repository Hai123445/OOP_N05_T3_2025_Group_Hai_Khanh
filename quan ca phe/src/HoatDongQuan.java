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
}
