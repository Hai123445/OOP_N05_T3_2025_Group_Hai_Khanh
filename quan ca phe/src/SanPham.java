import java.util.ArrayList;
import java.util.Scanner;
public class SanPham {
    String maSp;
    String tenSp;
    int giaSp;
    
    public SanPham(String maSp, String tenSp, int giaSp) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.giaSp = giaSp;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public void setGiaSp(int giaSp) {
        this.giaSp = giaSp;
    }
    public void printInfo() {
        System.out.println("Tên sản phẩm:"+ tenSp);
        System.out.println("Mã sản phẩm: " + maSp);
        System.out.println("Giá sản phẩm: " + giaSp);

    }
    private ArrayList<SanPham> danhSachSp = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    public void themSanPham() {
        System.out.print("Nhập mã SP: ");
        String ma = sc.nextLine();
        System.out.print("Nhập tên SP: ");
        String ten = sc.nextLine();
        System.out.print("Nhập giá SP: ");
        int gia = Integer.parseInt(sc.nextLine());

        SanPham sp = new SanPham(ma, ten, gia);
        danhSachSp.add(sp);
        System.out.println(" Đã thêm sản phẩm.");
    }
     public void hienThiSanPham() {
        if (danhSachSp.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (SanPham sp : danhSachSp) {
            sp.printInfo();
            System.out.println("--------------");
        }
    }
    public void suaSanPham() {
        System.out.println("Nhập mã sản phẩm cần sửa: ");
        String ma = sc.nextLine();
        for (SanPham sp : danhSachSp) {
            if (sp.getMaSp().equals(ma)) {
                System.out.println("Nhập tên mới");
                String tenMoi = sc.nextLine();
                System.out.print("Nhập giá mới: ");
                int giaMoi = Integer.parseInt(sc.nextLine());
                sp.setTenSp(tenMoi);
                sp.setGiaSp(giaMoi);
                System.out.println("Đã sửa sản phẩm");
                return;

            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã: " +ma);
    }
    public void xoaSanPham() {
        System.out.println("Nhập mã sản phẩm cần xóa");
        String ma = sc.nextLine();
        for (SanPham sp : danhSachSp){
            if (sp.getMaSp().equals(ma)) {
                danhSachSp.remove(sp);
                System.out.println("🗑️ Đã xóa sản phẩm");
                return;
            }
        }
        System.out.println("❌ Không tìm thấy sản phẩm có mã: " + ma);
    }
}