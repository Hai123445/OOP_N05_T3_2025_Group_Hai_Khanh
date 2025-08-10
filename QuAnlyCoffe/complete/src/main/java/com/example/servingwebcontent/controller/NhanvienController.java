package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Nhanvien;
import com.example.servingwebcontent.service.NhanvienService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhanvien")
public class NhanvienController {

    private final NhanvienService nhanvienService;

    public NhanvienController(NhanvienService nhanvienService) {
        this.nhanvienService = nhanvienService;
    }

    // Lấy danh sách nhân viên
    @GetMapping
    public String listNhanvien(Model model) {
        List<Nhanvien> danhSach = nhanvienService.getAll();
        model.addAttribute("nhanvien", danhSach);
        return "nhanvien";
    }

    // Thêm nhân viên mới
    @PostMapping("/add")
    public String addNhanvien(
            @RequestParam String tenNv,
            @RequestParam String sdt
    ) {
        String maNv = nhanvienService.generateMaNhanVien();
        Nhanvien nv = new Nhanvien(maNv, tenNv, sdt);
        nhanvienService.save(nv);
        return "redirect:/nhanvien";
    }

    // Sửa nhân viên
    @PostMapping("/edit")
    public String editNhanvien(
            @RequestParam String maNv,
            @RequestParam String tenNv,
            @RequestParam String sdt
    ) {
        Nhanvien existing = nhanvienService.findById(maNv);
        if (existing != null) {
            existing.setTenNv(tenNv);
            existing.setSdt(sdt);
            nhanvienService.save(existing);
        }
        return "redirect:/nhanvien";
    }

    // Xóa nhân viên
    @PostMapping("/delete")
    public String deleteNhanvien(@RequestParam String maNv) {
        nhanvienService.deleteById(maNv);
        return "redirect:/nhanvien";
    }
}

