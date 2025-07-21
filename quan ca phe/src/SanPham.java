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
        System.out.println("Tên sản phẩm: " + tenSp);
        System.out.println("Mã sản phẩm: " + maSp);
        System.out.println("Giá sản phẩm: " + giaSp);
    }

    private ArrayList<SanPham> danhSachSp = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // Phương thức thêm sản phẩm
    public void themSanPham() {
        try {
            System.out.print("Nhập mã SP: ");
            String ma = sc.nextLine();
            System.out.print("Nhập tên SP: ");
            String ten = sc.nextLine();
            System.out.print("Nhập giá SP: ");
            int gia = Integer.parseInt(sc.nextLine());  // Có thể gây lỗi khi nhập không phải số

            SanPham sp = new SanPham(ma, ten, gia);
            danhSachSp.add(sp);
            System.out.println("Đã thêm sản phẩm.");
        } catch (NumberFormatException e) {
            System.out.println("❌ Lỗi: Giá sản phẩm phải là một số hợp lệ.");
        } catch (Exception e) {
            System.out.println("❌ Đã xảy ra lỗi: " + e.getMessage());
        }
    }

    // Phương thức hiển thị sản phẩm
    public void hienThiSanPham() {
        try {
            if (danhSachSp.isEmpty()) {
                System.out.println("Danh sách trống.");
                return;
            }
            for (SanPham sp : danhSachSp) {
                sp.printInfo();
                System.out.println("--------------");
            }
        } catch (Exception e) {
            System.out.println("❌ Đã xảy ra lỗi khi hiển thị sản phẩm: " + e.getMessage());
        }
    }

    // Phương thức sửa sản phẩm
    public void suaSanPham() {
        try {
            System.out.println("Nhập mã sản phẩm cần sửa: ");
            String ma = sc.nextLine();
            boolean found = false;
            for (SanPham sp : danhSachSp) {
                if (sp.getMaSp().equals(ma)) {
                    System.out.println("Nhập tên mới: ");
                    String tenMoi = sc.nextLine();
                    System.out.print("Nhập giá mới: ");
                    int giaMoi = Integer.parseInt(sc.nextLine());  // Lỗi nếu nhập không phải số
                    sp.setTenSp(tenMoi);
                    sp.setGiaSp(giaMoi);
                    System.out.println("Đã sửa sản phẩm.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("❌ Không tìm thấy sản phẩm có mã: " + ma);
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Lỗi: Giá mới phải là một số hợp lệ.");
        } catch (Exception e) {
            System.out.println("❌ Đã xảy ra lỗi: " + e.getMessage());
        }
    }

    // Phương thức xóa sản phẩm
    public void xoaSanPham() {
        try {
            System.out.println("Nhập mã sản phẩm cần xóa: ");
            String ma = sc.nextLine();
            boolean found = false;
            for (SanPham sp : danhSachSp) {
                if (sp.getMaSp().equals(ma)) {
                    danhSachSp.remove(sp);
                    System.out.println("🗑️ Đã xóa sản phẩm.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("❌ Không tìm thấy sản phẩm có mã: " + ma);
            }
        } catch (Exception e) {
            System.out.println("❌ Đã xảy ra lỗi: " + e.getMessage());
        }
    }
}

