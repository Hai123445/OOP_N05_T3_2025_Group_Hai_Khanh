public class Nhanvien {
    String MaNv;
    String TenNv;
    String sdt;

    public Nhanvien(String maNv, String tenNv) {
        this.MaNv = maNv;
        this.TenNv = tenNv;
        this.sdt = sdt;
    }
    public void printTnNV(String tenNv){
        System.out.println("Ten NV:"+tenNv);
    }
    public void hienthi() {
        System.out.println("Ma Nhan vien:" + MaNv);
        System.out.println("Ten Nhan vien: " + TenNv);
        System.out.println("So dien thoai: " + sdt);
    }
    public void suaNV(String tenMoi){
        this.TenNv=tenMoi;
    }
    public void xoaNV(){
        this.MaNv="";
        this.TenNv="";
        this.sdt="";
    }
}    
