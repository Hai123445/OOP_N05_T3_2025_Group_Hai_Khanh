package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.repository.KHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KHService {

    @Autowired
    private KHRepository khRepository;

    public List<KhachHang> findAll() {
        return khRepository.findAll();
    }

    public KhachHang save(KhachHang khachHang) {
        return khRepository.save(khachHang);
    }

    public void deleteById(String id) {
        khRepository.deleteById(id);
    }

    public KhachHang findById(String id) {
        return khRepository.findById(id).orElse(null);
    }

}