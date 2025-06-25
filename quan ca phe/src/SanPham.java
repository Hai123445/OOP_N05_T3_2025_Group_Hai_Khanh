public class SanPham {
    int MaSp;
    String TenSp;
    int GiaSp;
    // phuong thuc

    // phuong thuc dac biet/constructor co ten trung ten class/ khoi tao Class
    // SanPham
    public SanPham(int maSp, String tenSp, int giaSp) {
        this.MaSp = maSp;
        this.TenSp = tenSp;
        this.GiaSp = giaSp;
    }

    public void In() {
        System.out.println("Ten san pham:"+ TenSp);

        System.out.println("Ma san pham: " + MaSp);
        System.out.println("Gia san pham: " + GiaSp);

    }
}