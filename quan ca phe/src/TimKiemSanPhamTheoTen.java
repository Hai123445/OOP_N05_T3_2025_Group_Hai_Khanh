import java.util.ArrayList;
import java.util.Scanner;

public class TimKiemSanPhamTheoTen {

    public static void timKiemTheoTen(ArrayList<SanPham> danhSachSanPham, Scanner scanner) {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String tenCanTim = scanner.nextLine().toLowerCase();

        boolean timThay = false;
        for (SanPham sp : danhSachSanPham) {
            if (sp.getTenSp().toLowerCase().contains(tenCanTim)) {
                System.out.println("Tìm thấy sản phẩm:");
                sp.inThongTin();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy sản phẩm nào với tên \"" + tenCanTim + "\"");
        }
    }
}
