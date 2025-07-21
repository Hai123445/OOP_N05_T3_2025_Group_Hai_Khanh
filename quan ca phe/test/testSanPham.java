import java.util.Scanner;

public class testSanPham {
    public static void test() {
        SanPham quanlySanPham = new SanPham("", "", 0); // Tạo đối tượng để gọi các phương thức quản lý
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("====== QUẢN LÝ SẢN PHẨM ======");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Sửa sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                   quanlySanPham.themSanPham();
                    break;
                case 2:
                    quanlySanPham.hienThiSanPham();
                    break;
                case 3:
                    quanlySanPham.suaSanPham();
                    break;
                case 4:
                    quanlySanPham.xoaSanPham();
                    break;
                case 0:
                    System.out.println("Thóat chương trình.");
                    break;
                default:
                    System.out.println("Chọn chức năng không hợp lệ");
            }
            System.out.println();
        } while (choice != 0);

        sc.close();
    }
}
