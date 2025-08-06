package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.SanPham;
import com.example.servingwebcontent.repository.SanPhamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SanPhamController {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    // Hiển thị danh sách sản phẩm
    @GetMapping("/sanpham")
    public String docSanPham(Model model) {
        List<SanPham> danhSachSanPham = sanPhamRepository.findAll();
        model.addAttribute("sanpham", danhSachSanPham);
        return "sanpham"; // Tên file HTML Thymeleaf để hiển thị
    }

    // Tạo mã sản phẩm tự động
    public String taoMaSanPham() {
        List<SanPham> danhSach = sanPhamRepository.findAll();
        int max = danhSach.size() + 1;
        return String.format("SP%03d", max); 
    }

    // Thêm sản phẩm mới
    @PostMapping("/sanpham/add")
    public String themSanPham(
            @RequestParam String tenSp,
            @RequestParam String maSp,
            @RequestParam int giaSp,
            @RequestParam String moTa, Model model) {

        String newMaSp = taoMaSanPham(); // Tạo mã tự động cho sản phẩm

        SanPham sp = new SanPham(newMaSp, tenSp, giaSp, moTa);
        sanPhamRepository.save(sp);

        return docSanPham(model);
    }

    // Sửa thông tin sản phẩm
    @PostMapping("/sanpham/edit")
    public String suaSanPham(
            @RequestParam String maSp,
            @RequestParam String tenSp,
            @RequestParam int giaSp,
            @RequestParam String moTa, Model model) {

        SanPham existing = sanPhamRepository.findById(maSp).orElse(null);
        if (existing != null) {
            existing.setTenSp(tenSp);
            existing.setGiaSp(giaSp);
            existing.setmota(moTa);
            sanPhamRepository.save(existing);
        }

        return docSanPham(model);
    }

    // Xóa sản phẩm
    @PostMapping("/sanpham/delete")
    public String xoaSanPham(@RequestParam String maSp, Model model) {
        sanPhamRepository.deleteById(maSp);
        return docSanPham(model);
    }
}
