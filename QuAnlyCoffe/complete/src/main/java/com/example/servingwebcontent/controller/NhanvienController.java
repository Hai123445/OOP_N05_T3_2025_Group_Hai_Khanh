package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.NhanVienAiven;
import com.example.servingwebcontent.model.NhanVien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NhanVienController {

    private final NhanVienAiven nhanVienDB = new NhanVienAiven();

    // Hiển thị danh sách nhân viên
    @GetMapping("/nhanvien")
    public String hienThiDanhSach(Model model) {
        try {
            List<NhanVien> ds = nhanVienDB.getAllNhanVien();
            model.addAttribute("nhanvien", ds);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi tải dữ liệu: " + e.getMessage());
        }
        return "nhanvien"; // file nhanvien.html (Thymeleaf)
    }

    // Thêm nhân viên
    @PostMapping("/nhanvien/add")
    public String themNhanVien(
            @RequestParam String tenNv,
            @RequestParam String sdt,
            @RequestParam String diaChi,
            Model model) {
        try {
            String newMaNv = taoMaNhanVien();
            NhanVien nv = new NhanVien(newMaNv, tenNv, sdt, diaChi);
            nhanVienDB.createNhanVien(nv);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi thêm nhân viên: " + e.getMessage());
        }
        return "redirect:/nhanvien";
    }

    // Sửa nhân viên
    @PostMapping("/nhanvien/edit")
    public String suaNhanVien(
            @RequestParam String maNv,
            @RequestParam String tenNv,
            @RequestParam String sdt,
            @RequestParam String diaChi,
            Model model) {
        try {
            NhanVien nv = new NhanVien(maNv, tenNv, sdt, diaChi);
            nhanVienDB.updateNhanVien(maNv, nv);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi sửa nhân viên: " + e.getMessage());
        }
        return "redirect:/nhanvien";
    }

    // Xóa nhân viên
    @PostMapping("/nhanvien/delete")
    public String xoaNhanVien(@RequestParam String maNv, Model model) {
        try {
            nhanVienDB.deleteNhanVien(maNv);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi xóa nhân viên: " + e.getMessage());
        }
        return "redirect:/nhanvien";
    }

    // Tạo mã nhân viên tự động NV001, NV002,...
    private String taoMaNhanVien() throws Exception {
        List<NhanVien> danhSach = nhanVienDB.getAllNhanVien();
        int max = danhSach.size() + 1;
        return String.format("NV%03d", max);
    }
}
