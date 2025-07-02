public class KhachHang{
    int MaKh;
    String TenKh;
    String sdt;



    // phuong thuc dac biet vi cung ten voi Lop --> Constructor
   public KhachHang(int maKh, String tenKh, String sdt) {
        this.MaKh = maKh;
        this.TenKh = tenKh;
        this.sdt = sdt;
}


public void hienthi(){
    System.out.println("Ten khach hang: " + TenKh);
    System.out.println("Ma khach hang:" + MaKh);
    System.out.println("sdt:" + sdt);
}



}
