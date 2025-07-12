public class Nhanvien {
    int MaNv;
    String TenNv;

    public Nhanvien(int MaNv, String TenNv) {
        this.MaNv = MaNv;
        this.TenNv = TenNv;
    }
    public void printTnNV(String TenNv){
        System.out.println("Ten NV:"+TenNv);
    }
    public void hienthi() {
        System.out.println("Ma Nhan vien:" + MaNv);
        System.out.println("Ten Nhan vien: " + TenNv);
    }
    public void SuaNv(String TenMoi){
        this.TenNv=TenMoi;
    }
    public void XoaNv(){
        this.MaNv=0;
        this.TenNv="";
    }
}
