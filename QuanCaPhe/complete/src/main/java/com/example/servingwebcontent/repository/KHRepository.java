package com.example.servingwebcontent.repository;
import com.example.servingwebcontent.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KHRepository extends JpaRepository<KhachHang, String> {

}