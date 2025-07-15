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
        System.out.println("Ten san pham:"+ tenSp);
        System.out.println("Ma san pham: " + maSp);
        System.out.println("Gia san pham: " + giaSp);

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
        System.out.println(" Da them san pham.");
    }
     public void hienThiSanPham() {
        if (danhSachSp.isEmpty()) {
            System.out.println("Danh sach trong.");
            return;
        }
        for (SanPham sp : danhSachSp) {
            sp.printInfo();
            System.out.println("--------------");
        }
    }
    public void suaSanPham() {
        System.out.println("Nhap ma san pham can sua: ");
        String ma = sc.nextLine();
        for (SanPham sp : danhSachSp) {
            if (sp.getMaSp().equals(ma)) {
                System.out.println("Nhap ten moi");
                String tenMoi = sc.nextLine();
                System.out.print("Nhap gia moi: ");
                int giaMoi = Integer.parseInt(sc.nextLine());
                sp.setTenSp(tenMoi);
                sp.setGiaSp(giaMoi);
                System.out.println("Da sua san pham");
                return;

            }
        }
        System.out.println("Khong tim thay san pham co ma: " +ma);
    }
    public void xoaSanPham() {
        System.out.println("Nhap ma san pham can xoa");
        String ma = sc.nextLine();
        for (SanPham sp : danhSachSp){
            if (sp.getMaSp().equals(ma)) {
                danhSachSp.remove(sp);
                System.out.println("🗑️ Da xoa san pham");
                return;
            }
        }
        System.out.println("❌ Khong tim thay san pham co ma: " + ma);
    }
}