// SanPham.java (Model)
public class SanPham {
    String maSp;
    String tenSp;
    int giaSp;

    // Constructor
    public SanPham(String maSp, String tenSp, int giaSp) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.giaSp = giaSp;
    }

    // Getters and Setters
    public String getMaSp() {
        return maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public int getGiaSp() {
        return giaSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public void setGiaSp(int giaSp) {
        this.giaSp = giaSp;
    }
}
