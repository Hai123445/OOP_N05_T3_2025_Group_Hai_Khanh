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

}