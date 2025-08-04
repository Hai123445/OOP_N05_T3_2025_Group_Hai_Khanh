public class LuongNvTheoGio {
    public static void TinhLuong() {
        Scanner scanner = new Scanner(System.in);

        // Nhập thông tin cho nhân viên
        System.out.println("===== Nhập thông tin nhân viên =====");
        System.out.print("Nhập mã nhân viên: ");
        String maNv = scanner.nextLine();

        System.out.print("Nhập tên nhân viên: ");
        String tenNv = scanner.nextLine();

        System.out.print("Nhập mức lương theo giờ (VNĐ): ");
        double luongTheoGio = scanner.nextDouble();

        // Tạo đối tượng nhân viên
        Nhanvien nv = new Nhanvien(maNv, tenNv, luongTheoGio);

        // Nhập số giờ làm của nhân viên
        System.out.print("Nhập số giờ làm trong tháng: ");
        double soGioLam = scanner.nextDouble();

        // Cập nhật số giờ làm cho nhân viên
        nv.capNhatSoGioLam(soGioLam);

        // Hiển thị thông tin và lương của nhân viên
        System.out.println("\n===== Thông tin và lương nhân viên =====");
        nv.hienthi();

        scanner.close();
    }
}
