
package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Nhanvien;
import com.example.servingwebcontent.repository.NhanvienRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NhanvienController {

    @Autowired
    private NhanvienRepository nhanvienRepository;

    // Hiển thị danh sách nhân viên
    @GetMapping("/nhanvien")
    public String docNhanVien(Model model) {
        List<Nhanvien> danhSachNhanVien = nhanvienRepository.findAll();
        model.addAttribute("nhanvien", danhSachNhanVien);
        return "nhanvien"; // Tên file HTML Thymeleaf
    }

    // Tạo mã nhân viên tự động
    public String taoMaNhanVien() {
        List<Nhanvien> danhSach = nhanvienRepository.findAll();
        int max = danhSach.size() + 1;
        return String.format("NV%03d", max);
    }

    // Thêm nhân viên mới
    @PostMapping("/nhanvien/add")
    public String themNhanVien(
            @RequestParam String tenNv,
            @RequestParam String sdt,
            Model model) {

        String newMaNv = taoMaNhanVien(); // Mã tự động

        Nhanvien nv = new Nhanvien(newMaNv, tenNv, sdt);
        nhanvienRepository.save(nv);

        return docNhanVien(model);
    }

    // Sửa thông tin nhân viên
    @PostMapping("/nhanvien/edit")
    public String suaNhanVien(
            @RequestParam String maNv,
            @RequestParam String tenNv,
            @RequestParam String sdt,
            Model model) {

        Nhanvien existing = nhanvienRepository.findById(maNv).orElse(null);
        if (existing != null) {
            existing.setTenNv(tenNv);
            existing.setSdt(sdt);
            nhanvienRepository.save(existing);
        }

        return docNhanVien(model);
    }

    // Xóa nhân viên
    @PostMapping("/nhanvien/delete")
    public String xoaNhanVien(@RequestParam String maNv, Model model) {
        nhanvienRepository.deleteById(maNv);
        return docNhanVien(model);
    }
}

