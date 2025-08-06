@PostMapping("/dathang")
@ResponseBody
public String datHang(@RequestParam String maKH, @RequestBody Map<String, Integer> gioHang) {
    Connection conn = null;
    PreparedStatement stmt = null;
    PreparedStatement stmtGia = null;
    ResultSet rs = null;

    try {
        conn = dbConnection.getConnection();
        conn.setAutoCommit(false);

        String maGD = "GD" + System.currentTimeMillis(); // Tạo mã giao dịch duy nhất

        String sqlGetGia = "SELECT Gia FROM sanpham WHERE MaSp = ?";
        stmtGia = conn.prepareStatement(sqlGetGia);

        String sqlInsert = "INSERT INTO donhang(MaGd, MaKh, MaSp, TongSoSp, TongTien) VALUES (?, ?, ?, ?, ?)";
        stmt = conn.prepareStatement(sqlInsert);

        for (Map.Entry<String, Integer> entry : gioHang.entrySet()) {
            String maSP = entry.getKey();
            int soLuong = entry.getValue();

            // Lấy giá sản phẩm
            stmtGia.setString(1, maSP);
            rs = stmtGia.executeQuery();

            if (rs.next()) {
                double gia = rs.getDouble("Gia");
                double tongTien = gia * soLuong;

                stmt.setString(1, maGD);
                stmt.setString(2, maKH);
                stmt.setString(3, maSP);
                stmt.setInt(4, soLuong); // Tổng số sản phẩm
                stmt.setDouble(5, tongTien); // Tổng tiền = giá × số lượng
                stmt.addBatch();
            } else {
                return "Sản phẩm không tồn tại: " + maSP;
            }
        }

        stmt.executeBatch();
        conn.commit();

        return "Đặt hàng thành công. Mã giao dịch: " + maGD;

    } catch (Exception e) {
        try {
            if (conn != null) conn.rollback();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        e.printStackTrace();
        return "Lỗi đặt hàng: " + e.getMessage();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (stmtGia != null) stmtGia.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
