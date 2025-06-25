public class Nhanvien{
    int MaNv;
    String TenNv;
    String sdt;



    // phuong thuc dac biet vi cung ten voi Lop --> Constructor
   public Nhanvien(int maNv, String tenNv, String sdt) {
        this.MaNv = maNv;
        this.TenNv = tenNv;
        this.sdt = sdt;
}


public void hienthi(){
    System.out.println("Ten Nhan vien: " + TenNv);
    System.out.println("Ma Nhan vien:" + MaNv);
    System.out.println("sdt:" + sdt);
}



}