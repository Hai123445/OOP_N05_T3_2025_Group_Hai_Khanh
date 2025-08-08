package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Nhanvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanvienRepository extends JpaRepository<Nhanvien, String> {
    // Nếu cần tìm kiếm nâng cao có thể thêm các method custom ở đây
}
