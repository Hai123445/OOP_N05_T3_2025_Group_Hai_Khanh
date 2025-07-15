public class KhachHang{
    String MaKh;
    String TenKh;
    String sdt;



    // phuong thuc dac biet vi cung ten voi Lop --> Constructor
   public KhachHang(String maKh, String tenKh, String sdt) {
        this.MaKh = maKh;
        this.TenKh = tenKh;
        this.sdt = sdt;
}
public String getMakh(){
    return MaKh;
}
public void setMakh(String maKh){
    this.MaKh = maKh;
}
public void setTenkh(String tenKh){
    this.TenKh = tenKh;
}
public void setSdt(String sdt){
    this.sdt = sdt;
}

public void hienthi(){
    System.out.println("Ten khach hang: " + TenKh);
    System.out.println("Ma khach hang:" + MaKh);
    System.out.println("sdt:" + sdt);
}



}
