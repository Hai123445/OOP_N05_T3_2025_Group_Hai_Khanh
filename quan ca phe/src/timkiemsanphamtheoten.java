import java.util.ArrayList;
import java.util.Scanner;

public class timkiemsanphamtheoten {
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
