package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.KhachHang;

import com.example.servingwebcontent.repository.KHRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class KHController {

   @Autowired
private KHRepository khRepository;

    // Hiển thị danh sách khách hàng
    @GetMapping("/khachhang")
    public String docKhachhang(Model model) {
        List<KhachHang> danhSachKhachHang = khRepository.findAll();
        model.addAttribute("khachhang", danhSachKhachHang);
        return "khachhang"; // Tên file HTML Thymeleaf để hiển thị
    }
    public String taoMaKhachHang() {
    List<KhachHang> danhSach = khRepository.findAll();
    int max = danhSach.size() + 1;
    return String.format("KH%03d", max); 
    }
    
    // Thêm khách hàng mới
    @PostMapping("/khachhang/add")
    public String themKhachHang(
            @RequestParam String tenKh,
            @RequestParam String maKh,
            @RequestParam String sdt,
            @RequestParam String diaChi, Model model) {

        String newmaKh = taoMaKhachHang();

        KhachHang kh = new KhachHang(newmaKh,tenKh,sdt,diaChi);
        khRepository.save(kh);

        return docKhachhang(model);
    }

    // Sửa thông tin khách hàng
    @PostMapping("/khachhang/edit")
    public String suaKhachHang(
            @RequestParam String maKh,
            @RequestParam String tenKh,
            @RequestParam String diaChi,
            @RequestParam String sdt, Model model) {

        KhachHang existing = khRepository.findById(maKh).orElse(null);
        if (existing != null) {
            existing.setTenkh(tenKh);
            existing.setDc(diaChi);
            existing.setSdt(sdt);
            khRepository.save(existing);
        }

        return docKhachhang(model);
    }

    // Xóa khách hàng
    @PostMapping("/khachhang/delete")
    public String xoaKhachHang(@RequestParam String maKh, Model model) {
        khRepository.deleteById(maKh);
        return docKhachhang(model);
    }
}
