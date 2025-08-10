package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.Nhanvien;
import com.example.servingwebcontent.repository.NhanvienRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class NhanvienService {

    private final NhanvienRepository repo;

    public NhanvienService(NhanvienRepository repo) {
        this.repo = repo;
    }

    public List<Nhanvien> getAll() {
        return repo.findAll();
    }

    public void save(Nhanvien nv) {
        repo.save(nv);
    }

    public Nhanvien findById(String id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repo.deleteById(id);
    }

    // Tạo mã NV dựa trên số lớn nhất trong DB
    public String generateMaNhanVien() {
        List<Nhanvien> all = repo.findAll();
        int maxNum = all.stream()
                .map(Nhanvien::getMaNv)
                .filter(code -> code.matches("NV\\d+"))
                .map(code -> Integer.parseInt(code.substring(2)))
                .max(Comparator.naturalOrder())
                .orElse(0);
        return String.format("NV%03d", maxNum + 1);
    }
}
