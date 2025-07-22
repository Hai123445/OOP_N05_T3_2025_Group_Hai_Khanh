import java.util.ArrayList;
import java.util.Scanner;

public class testNhanvien {
    static ArrayList<Nhanvien> danhSachNV = new ArrayList<>();
    static ArrayList<Giaodich> dsGiaodich = new ArrayList<>();
    static ArrayList<SanPham> dsSanpham = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void menu(){
        int chon;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Sửa tên nhân viên theo mã");
            System.out.println("4. Xóa nhân viên theo mã");
            System.out.println("5. Tính lương nhân viên theo mã");
            System.out.println("6. Thống kê giao dịch");
            System.out.println("7. Thêm giao dịch");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            chon = scanner.nextInt();
            scanner.nextLine();

            switch (chon) {
                case 1:
                    System.out.print("Nhập mã NV: ");
                    String ma = scanner.nextLine();
                    System.out.print("Nhập tên NV: ");
                    String ten = scanner.nextLine();
                    danhSachNV.add(new Nhanvien(ma, ten));
                    break;

                case 2:
                    System.out.println("--- Danh sách nhân viên ---");
                    for (Nhanvien nv : danhSachNV) {
                        nv.hienthi();
                        System.out.println("------------------");
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã NV cần sửa: ");
                    String maSua = scanner.nextLine();
                    boolean foundSua = false;
                    for (Nhanvien nv : danhSachNV) {
                        if (nv.MaNv.equals(maSua)) {
                            System.out.print("Nhập tên mới: ");
                            String tenMoi = scanner.nextLine();
                            nv.suaNV(tenMoi);
                            foundSua = true;
                            System.out.println("Đã sửa tên nhân viên.");
                            break;
                        }
                    }
                    if (!foundSua) {
                        System.out.println("Không tìm thấy nhân viên!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã NV cần xóa: ");
                    String maXoa = scanner.nextLine();
                    boolean foundXoa = false;
                    for (int i = 0; i < danhSachNV.size(); i++) {
                        if (danhSachNV.get(i).MaNv.equals(maXoa)) {
                            danhSachNV.remove(i);
                            foundXoa = true;
                            System.out.println("Đã xóa nhân viên.");
                            break;
                        }
                    }
                    if (!foundXoa) {
                        System.out.println("Không tìm thấy nhân viên!");
                    }
                    break;

                case 5:
                    System.out.println("Nhập mã NV cần tính lương: ");
                    String maLuong = scanner.nextLine();
                    boolean found = false;
                    for (Nhanvien nv : danhSachNV) {
                        if (nv.MaNv.equals(maLuong)) {
                            System.out.print("Nhập số giờ làm: ");
                            double gio = scanner.nextDouble();
                            scanner.nextLine();
                            double luong = nv.tinhLuong(gio);
                            System.out.println("Lương của nhân viên là: " + luong + " VND");
                            found = true;
                            break;
                        }
                    }
                    if (!found){
                        System.out.println("Không tìm thấy nhân viên!");
                    }
                    break;
                case 6:
                    ThongKe.thongKeGiaoDich(dsGiaodich, danhSachNV, dsSanpham);
                    break;
                case 7:
                    ThongKe.themGiaoDich(dsGiaodich, danhSachNV);
                    break;    

                case 0:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Chọn sai! Vui lòng chọn lại.");
            }

        } while (chon != 0);

        scanner.close();
    }
}    
