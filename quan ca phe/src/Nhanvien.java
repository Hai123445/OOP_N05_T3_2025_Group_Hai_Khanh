public class Nhanvien {
    String MaNv;
    String TenNv;
    double luongTheoGio;

    public Nhanvien(String maNv, String tenNv) {
        this.MaNv = maNv;
        this.TenNv = tenNv;
        this.luongTheoGio = 50000;
    }
    public double tinhLuong(double soGioLam){
        return luongTheoGio*soGioLam;
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
        this.MaNv="";
        this.TenNv="";
    }
}    
