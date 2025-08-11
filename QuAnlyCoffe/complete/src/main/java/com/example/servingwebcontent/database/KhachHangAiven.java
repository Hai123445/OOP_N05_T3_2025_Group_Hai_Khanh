/* 
package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.KhachHang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangAiven {

    private final String jdbcUrl = "jdbc:mysql://mysql-2954f5bb-opp-data.j.aivencloud.com:14833/defaultdb?sslMode=REQUIRED";
    private final String jdbcUsername = "avnadmin";
    private final String jdbcPassword = "AVNS_fIeg8rQ_jgkVDcDFWyn";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
    }

    // Lấy danh sách tất cả khách hàng
    public List<KhachHang> getAllKhachHang() throws SQLException {
        List<KhachHang> list = new ArrayList<>();

        String sql = "SELECT * FROM khachhang";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String ma = rs.getString("ma_kh");
                String ten = rs.getString("ten_kh");
                String sdt = rs.getString("sdt");
                String diachi = rs.getString("dia_chi");

                KhachHang kh = new KhachHang(ma, ten, sdt, diachi);
                list.add(kh);
            }
        }

        return list;
    }

    // Thêm khách hàng mới
    public boolean createKhachHang(KhachHang kh) throws SQLException {
        String sql = "INSERT INTO khachhang(ma_kh, ten_kh, sdt, dia_chi) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, kh.getMakh());
            pstmt.setString(2, kh.getTenkh());
            pstmt.setString(3, kh.getsdt());
            pstmt.setString(4, kh.getDc());

            return pstmt.executeUpdate() > 0;
        }
    }

    // Cập nhật khách hàng
    public boolean updateKhachHang(String maKh, KhachHang newKh) throws SQLException {
        String sql = "UPDATE khachhang SET ten_kh = ?, sdt = ?, dia_chi = ? WHERE ma_kh = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newKh.getTenkh());
            pstmt.setString(2, newKh.getsdt());
            pstmt.setString(3, newKh.getDc());
            pstmt.setString(4, maKh);

            return pstmt.executeUpdate() > 0;
        }
    }

    // Xóa khách hàng
    public boolean deleteKhachHang(String maKh) throws SQLException {
        String sql = "DELETE FROM khachhang WHERE ma_kh = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, maKh);
            return pstmt.executeUpdate() > 0;
        }
    }
}
*/