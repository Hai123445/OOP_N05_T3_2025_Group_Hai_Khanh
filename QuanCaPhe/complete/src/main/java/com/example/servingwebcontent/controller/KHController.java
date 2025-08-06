package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.KhachHangAiven;
import com.example.servingwebcontent.model.KhachHang;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class KHController {

    private final KhachHangAiven khachHangDB = new KhachHangAiven();

    // Hiển thị danh sách khách hàng
    @GetMapping("/khachhang")
    public String hienThiDanhSach(Model model) {
        try {
            List<KhachHang> ds = khachHangDB.getAllKhachHang();
            model.addAttribute("khachhang", ds);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi tải dữ liệu: " + e.getMessage());
        }
        return "khachhang"; // file .html
    }

    // Thêm khách hàng
    @PostMapping("/khachhang/add")
    public String themKhachHang(
            @RequestParam String tenKh,
            @RequestParam String sdt,
            @RequestParam String diaChi,
            Model model) {

        try {
            String newMaKh = taoMaKhachHang();
            KhachHang kh = new KhachHang(newMaKh, tenKh, sdt, diaChi);
            khachHangDB.createKhachHang(kh);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi thêm khách hàng: " + e.getMessage());
        }

        return "redirect:/khachhang";
    }

    // Sửa khách hàng
    @PostMapping("/khachhang/edit")
    public String suaKhachHang(
            @RequestParam String maKh,
            @RequestParam String tenKh,
            @RequestParam String sdt,
            @RequestParam String diaChi,
            Model model) {

        try {
            KhachHang newKh = new KhachHang(maKh, tenKh, sdt, diaChi);
            khachHangDB.updateKhachHang(maKh, newKh);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi sửa khách hàng: " + e.getMessage());
        }

        return "redirect:/khachhang";
    }

    // Xóa khách hàng
    @PostMapping("/khachhang/delete")
    public String xoaKhachHang(@RequestParam String maKh, Model model) {
        try {
            khachHangDB.deleteKhachHang(maKh);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi xóa khách hàng: " + e.getMessage());
        }

        return "redirect:/khachhang";
    }

    // Tạo mã khách hàng mới tự động: KH001, KH002,...
    private String taoMaKhachHang() throws Exception {
        List<KhachHang> danhSach = khachHangDB.getAllKhachHang();
        int max = danhSach.size() + 1;
        return String.format("KH%03d", max);
    }
}
