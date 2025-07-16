import java.util.Scanner;

public class testSanPham {
    public static void test() {
        SanPham quanlySanPham = new SanPham("", "", 0); // Tạo đối tượng để gọi các phương thức quản lý
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("====== QUAN LY SAN PHAM ======");
            System.out.println("1. Them san pham");
            System.out.println("2. Hien thi danh sach san pham");
            System.out.println("3. Sua san pham");
            System.out.println("4. Xóa san pham");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
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
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Chon chuc nang khong hop le");
            }
            System.out.println();
        } while (choice != 0);

        sc.close();
    }
}
