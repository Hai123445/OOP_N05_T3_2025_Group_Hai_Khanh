package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Nhanvien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanvienAiven {

    // Thông tin kết nối Aiven MySQL
    private final String jdbcUrl = "jdbc:mysql://mysql-2954f5bb-opp-data.j.aivencloud.com:14833/defaultdb?sslMode=REQUIRED";
    private final String jdbcUsername = "avnadmin";
    private final String jdbcPassword = "AVNS_fIeg8rQ_jgkVDcDFWyn";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
    }

    // Lấy tất cả nhân viên
    public List<Nhanvien> getAllNhanvien() throws SQLException {
        List<Nhanvien> list = new ArrayList<>();
        String sql = "SELECT * FROM nhanvien";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String maNv = rs.getString("maNv");
                String tenNv = rs.getString("tenNv");
                String sdt = rs.getString("sdt");

                Nhanvien nv = new Nhanvien(maNv, tenNv, sdt);
                list.add(nv);
            }
        }

        return list;
    }

    // Lấy nhân viên theo mã
    public Nhanvien getNhanvienById(String maNv) throws SQLException {
        String sql = "SELECT * FROM nhanvien WHERE maNv = ?";
        Nhanvien nv = null;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, maNv);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                nv = new Nhanvien(
                        rs.getString("maNv"),
                        rs.getString("tenNv"),
                        rs.getString("sdt")
                );
            }

            rs.close();
        }

        return nv;
    }

    // Tạo nhân viên
    public boolean createNhanvien(Nhanvien nv) throws SQLException {
        String sql = "INSERT INTO nhanvien (maNv, tenNv, sdt) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nv.getMaNv());
            pstmt.setString(2, nv.getTenNv());
            pstmt.setString(3, nv.getSdt());

            return pstmt.executeUpdate() > 0;
        }
    }

    // Cập nhật nhân viên
    public boolean updateNhanvien(String maNv, Nhanvien nv) throws SQLException {
        String sql = "UPDATE nhanvien SET tenNv = ?, sdt = ? WHERE maNv = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nv.getTenNv());
            pstmt.setString(2, nv.getSdt());
            pstmt.setString(3, maNv);

            return pstmt.executeUpdate() > 0;
        }
    }

    // Xóa nhân viên
    public boolean deleteNhanvien(String maNv) throws SQLException {
        String sql = "DELETE FROM nhanvien WHERE maNv = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, maNv);
            return pstmt.executeUpdate() > 0;
        }
    }
}
