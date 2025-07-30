import java.util.ArrayList;
import java.util.Scanner;

import com.example.servingwebcontent.Giaodich;
public class Gdtrongngay extends Giaodich{
  public Gdtrongngay(String MaGiaoDich, String NgayThangNamGiaoDich, String NhanVienGiaoDich, double TongTien, int TongSoSp) {
        super(MaGiaoDich, NgayThangNamGiaoDich, NhanVienGiaoDich, TongTien, TongSoSp);
        }
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
