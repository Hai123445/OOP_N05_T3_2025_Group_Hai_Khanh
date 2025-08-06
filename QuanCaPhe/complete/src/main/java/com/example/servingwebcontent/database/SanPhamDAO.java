/* 
package com.example.demo.dao;

import com.example.demo.model.SanPham;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SanPhamDAO {
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    private Connection conn;

    @PostConstruct
    public void init() {
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException("Không thể kết nối DB", e);
        }
    }

    public List<SanPham> getAll() throws SQLException {
        List<SanPham> ds = new ArrayList<>();
        String sql = "SELECT * FROM sanpham";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            ds.add(new SanPham(
                rs.getInt("id"),
                rs.getString("ten"),
                rs.getDouble("gia"),
                rs.getString("mota")
            ));
        }
        return ds;
    }

    public SanPham getById(int id) throws SQLException {
        String sql = "SELECT * FROM sanpham WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new SanPham(
                rs.getInt("id"),
                rs.getString("ten"),
                rs.getDouble("gia"),
                rs.getString("mota")
            );
        }
        return null;
    }

    public void insert(SanPham sp) throws SQLException {
        String sql = "INSERT INTO sanpham (ten, gia, mota) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, sp.getTen());
        ps.setDouble(2, sp.getGia());
        ps.setString(3, sp.getMota());
        ps.executeUpdate();
    }

    public void update(int id, SanPham sp) throws SQLException {
        String sql = "UPDATE sanpham SET ten = ?, gia = ?, mota = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, sp.getTen());
        ps.setDouble(2, sp.getGia());
        ps.setString(3, sp.getMota());
        ps.setInt(4, id);
        ps.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM sanpham WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
    */