public class SanPham {
    String maSp;
    String tenSp;
    int giaSp;
    
    public SanPham(String maSp, String tenSp, int giaSp) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.giaSp = giaSp;
    }

    public void printInfo() {
        System.out.println("Ten san pham:"+ tenSp);
        System.out.println("Ma san pham: " + maSp);
        System.out.println("Gia san pham: " + giaSp);

    }

    public void suaSp(String tenMoi, int giaMoi) {
        this.tenSp = tenMoi;
        this.giaSp = giaMoi;
    }
    public void xoaSp() {
        this.maSp= "";
        this.tenSp = "";
        this.giaSp = 0;
    }
}