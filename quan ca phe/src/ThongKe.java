import java.util.ArrayList;
import java.util.Scanner;

public class ThongKe {
    static Scanner scanner = new Scanner(System.in);

    public static void themSanPham(ArrayList<SanPham> dsSanpham) {
        System.out.println("--- THÊM SẢN PHẨM ---");
        System.out.print("Nhập mã sản phẩm: ");
        String ma = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double gia = scanner.nextDouble();
        scanner.nextLine(); // clear buffer
        

        dsSanpham.add(new SanPham(ma,ten,(int)gia));
        System.out.println("Đã thêm sản phẩm.");
    }

    public static void themGiaoDich(
            ArrayList<Giaodich> dsGiaodich,
            ArrayList<Nhanvien> dsNhanvien
    ) {
        System.out.println("\n--- THÊM GIAO DỊCH ---");
        System.out.print("Nhập mã giao dịch: ");
        String mgd = scanner.nextLine();
        System.out.print("Nhập ngày giao dịch: ");
        String ngd = scanner.nextLine();
        System.out.print("Nhập mã nhân viên giao dịch: ");
        String nvgd = scanner.nextLine();

        // Kiểm tra mã NV có tồn tại không
        boolean foundNv = false;
        for (Nhanvien nv : dsNhanvien) {
            if (nv.MaNv.equalsIgnoreCase(nvgd)) {
                foundNv = true;
                break;
            }
        }
        if (!foundNv) {
            System.out.println(" Mã nhân viên không tồn tại.");
            return;
        }

        System.out.print("Nhập tổng tiền giao dịch: ");
        double tt = scanner.nextDouble();
        System.out.print("Nhập tổng số sản phẩm: ");
        int tsp = scanner.nextInt();
        scanner.nextLine();

        dsGiaodich.add(new Giaodich(mgd, ngd, nvgd, tt, tsp));
        System.out.println(" Đã thêm giao dịch.");
    }

    public static void thongKeGiaoDich(
            ArrayList<Giaodich> dsGiaodich,
            ArrayList<Nhanvien> dsNhanvien,
            ArrayList<SanPham> dsSanpham
    ) {
        if (dsGiaodich == null || dsGiaodich.isEmpty()) {
            System.out.println(" Không có giao dịch nào để thống kê.");
            return;
        }

        System.out.println(" THỐNG KÊ GIAO DỊCH THEO NHÂN VIÊN:");
        System.out.println("========================================");

        for (Giaodich gd : dsGiaodich) {
            System.out.println(" Mã giao dịch: " + gd.getMgd());
            System.out.println(" Ngày giao dịch: " + gd.getNgd());
            System.out.println(" Mã nhân viên giao dịch: " + gd.getNvgd());

            // Tìm tên nhân viên
            boolean foundNv = false;
            for (Nhanvien nv : dsNhanvien) {
                if (nv.MaNv.equalsIgnoreCase(gd.getNvgd())) {
                    System.out.println(" Tên nhân viên: " + nv.TenNv);
                    foundNv = true;
                    break;
                }
            }
            if (!foundNv) {
                System.out.println(" Không tìm thấy thông tin nhân viên.");
            }

            System.out.println(" Tổng tiền giao dịch: " + gd.getTt());
            System.out.println(" Tổng số sản phẩm: " + gd.getTsp());

            if (dsSanpham != null && !dsSanpham.isEmpty()) {
                System.out.println(" Danh sách sản phẩm hiện tại:");
                for (SanPham sp : dsSanpham) {
                    System.out.println(" >  " + sp.tenSp + " | Mã: " + sp.maSp + " | Giá: " + sp.giaSp);
                }
            } else {
                System.out.println(" Danh sách sản phẩm trống.");
            }

            System.out.println("----------------------------------------");
        }
    }
}

