package com.example.servingwebcontent.service;

import com.example.servingwebcontent.controller.GDController;
import com.example.servingwebcontent.model.Giaodich;
import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.SanPham;
import com.example.servingwebcontent.repository.GDRepository;
import com.example.servingwebcontent.repository.SanPhamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.transaction.Transactional;
import java.util.Optional;
@Service
public class GDService {

    @Autowired
    private GDRepository gdRepository;
    public SanPhamRepository spRepository;

    public List<Giaodich> findAll() {
        return gdRepository.findAll();
    }

    public Giaodich save(Giaodich gd) {
        return gdRepository.save(gd);
    }

    public void deleteById(String id) {
        gdRepository.deleteById(id);
    }

    @Transactional
    

    public Giaodich findById(String id) {
        return gdRepository.findById(id).orElse(null);
    }
     public boolean datHang(String masp, String nvgd, int tsp, double tt) {
        Optional<SanPham> sanPhamOpt = spRepository.findById(masp);
        if (sanPhamOpt.isEmpty()) {
            System.out.println("Sản phẩm không tồn tại.");
            return false;
        }

        SanPham sp = sanPhamOpt.get();
        double tongTien = sp.getGiaSp() * tsp;

        Giaodich gd = new Giaodich();
        gd.setMgd("GD" + System.currentTimeMillis());
        gd.setNgd(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        gd.setNvgd(nvgd);
        gd.setTsp(tsp);
        gd.setTt(tongTien);
        

        gdRepository.save(gd);
        return true;
    }
}

