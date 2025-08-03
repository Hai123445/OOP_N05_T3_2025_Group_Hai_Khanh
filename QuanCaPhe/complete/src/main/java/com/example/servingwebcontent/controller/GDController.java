package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Giaodich;


import com.example.servingwebcontent.repository.GDRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class GDController{
   @Autowired
private GDRepository gdRepository;

    
    @GetMapping("/customers")
    public String docGiaodich(Model model) {
        List<Giaodich> danhSachGiaodich = gdRepository.findAll();
        model.addAttribute("customers", danhSachGiaodich);
        return "customer"; // Tên file HTML Thymeleaf để hiển thị
    }
    public String taoMaGiaodich() {
    List<Giaodich> danhSach = gdRepository.findAll();
    int max = danhSach.size() + 1;
    return String.format("GD%03d", max); 
    }

    @PostMapping("/giaodich/add")
    public String themGiaodich(
            @RequestParam String maGd,
            @RequestParam String timeGd,
            @RequestParam String nvGd,
            @RequestParam double tongTien,
            @RequestParam int tongSp, Model model) {

        String newmaGd = taoMaGiaodich();

        Giaodich gd = new Giaodich(newmaGd,timeGd,nvGd,tongTien,tongSp);
        gdRepository.save(gd);

        return docGiaodich(model);
    }

    
    @PostMapping("/giaodich/edit")
    public String suaGiaodich(
            @RequestParam String maGd,
            @RequestParam String timeGd,
            @RequestParam String nvGd,
            @RequestParam double tongTien,
            @RequestParam int tongSp, Model model) {

        Giaodich existing = gdRepository.findById(maGd).orElse(null);
        if (existing != null) {

            existing.setNgd(timeGd);
            existing.setNvgd(nvGd);
            existing.setTt(tongTien);
            existing.setTsp(tongSp);
            gdRepository.save(existing);
        }

        return docGiaodich(model);
    }

    
    @PostMapping("/giaodich/delete")
    public String xoaGiaodich(@RequestParam String maGd, Model model) {
        gdRepository.deleteById(maGd);
        return docGiaodich(model);
    }
}