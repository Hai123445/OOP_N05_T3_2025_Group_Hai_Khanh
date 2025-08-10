package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.NhanVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVienAiven {
    private final String jdbcUrl = "jdbc:mysql://mysql-2954f5bb-opp-data.j.aivencloud.com:14833/defaultdb?sslMode=REQUIRED";
    private final String jdbcUsername = "avnadmin";
    private final String jdbcPassword = "AVNS_fIeg8rQ_jgkVDcDFWyn";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
    }

    // Lấy danh sách nhân viên
    public List<NhanVien> getAllNhanVien() throws SQLException {
        List<NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM nhanvien";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new NhanVien(
                        rs.getString("ma_nv"),
                        rs.getString("ten_nv"),
                        rs.getString("sdt"),
                        rs.getString("dia_chi")
                ));
            }
        }
        return list;
    }

    // Thêm nhân viên
    public boolean createNhanVien(NhanVien nv) throws SQLException {
        String sql = "INSERT INTO nhanvien(ma_nv, ten_nv, sdt, dia_chi) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nv.getMaNv());
            pstmt.setString(2, nv.getTenNv());
            pstmt.setString(3, nv.getSdt());
            pstmt.setString(4, nv.getDiaChi());
            return pstmt.executeUpdate() > 0;
        }
    }

    // Cập nhật nhân viên
    public boolean updateNhanVien(String maNv, NhanVien nv) throws SQLException {
        String sql = "UPDATE nhanvien SET ten_nv=?, sdt=?, dia_chi=? WHERE ma_nv=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nv.getTenNv());
            pstmt.setString(2, nv.getSdt());
            pstmt.setString(3, nv.getDiaChi());
            pstmt.setString(4, maNv);
            return pstmt.executeUpdate() > 0;
        }
    }

    // Xóa nhân viên
    public boolean deleteNhanVien(String maNv) throws SQLException {
        String sql = "DELETE FROM nhanvien WHERE ma_nv=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maNv);
            return pstmt.executeUpdate() > 0;
        }
    }
}
