import java.util.ArrayList;
import java.util.Scanner;

import com.example.servingwebcontent.model.Giaodich;

public class testNhanvien {
    static ArrayList<Nhanvien> danhSachNV = new ArrayList<>();
    static ArrayList<Giaodich> dsGiaodich = new ArrayList<>();
    static ArrayList<SanPham> dsSanpham = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void menu(){
        int chon;
        do {
            System.out.println("====== QUẢN LÝ NHÂN VIÊN ======");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Sửa tên nhân viên theo mã");
            System.out.println("4. Xóa nhân viên theo mã");
            System.out.println("5. Thống kê giao dịch");
            System.out.println("6. Thêm giao dịch");
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
                    System.out.print("Nhập số điện thoại: ");
                    String sdt = scanner.nextLine();
                    danhSachNV.add(new Nhanvien(ma, ten, sdt));
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
                    ThongKe.thongKeGiaoDich(dsGiaodich, danhSachNV, dsSanpham);
                    break;
                case 6:
                    ThongKe.themGiaoDich(dsGiaodich, danhSachNV);
                    break;    

                case 0:
                    System.out.println("Thoát menu.");
                    break;

                default:
                    System.out.println("Chọn sai! Vui lòng chọn lại.");
            }

        } while (chon != 0);
    }
}    
