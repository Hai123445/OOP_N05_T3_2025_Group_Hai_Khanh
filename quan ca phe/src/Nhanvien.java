import java.util.ArrayList;
import java.util.List;
public class Nhanvien {
    int MaNv;
    String TenNv;

    public Nhanvien(int maNv, String tenNv) {
        this.MaNv = maNv;
        this.TenNv = tenNv;
    }
    public void printTnNV(String tenNv){
        System.out.println("Ten NV:"+tenNv);
    }
    public void hienthi() {
        System.out.println("Ma Nhan vien:" + MaNv);
        System.out.println("Ten Nhan vien: " + TenNv);
    }
    public void suaNV(String tenMoi){
        this.TenNv=tenMoi;
    }
    public void xoaNV(){
        this.MaNv=0;
        this.TenNv="";
    }
public static void Danhsach() {
        ArrayList<Nhanvien> danhSachNV = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int chon;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Sửa tên nhân viên theo mã");
            System.out.println("4. Xóa nhân viên theo mã");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            chon = scanner.nextInt();
            scanner.nextLine();

            switch (chon) {
                case 1:
                    System.out.print("Nhập mã NV: ");
                    int ma = scanner.nextInt();
                    scanner.nextLine();
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
                    int maSua = scanner.nextInt();
                    scanner.nextLine();
                    boolean foundSua = false;
                    for (Nhanvien nv : danhSachNV) {
                        if (nv.MaNv == maSua) {
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
                    int maXoa = scanner.nextInt();
                    boolean foundXoa = false;
                    for (int i = 0; i < danhSachNV.size(); i++) {
                        if (danhSachNV.get(i).MaNv == maXoa) {
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
