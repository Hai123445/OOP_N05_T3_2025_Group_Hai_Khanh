package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Giaodich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GDRepository extends JpaRepository<Giaodich, String> {
    // Bạn có thể thêm các phương thức truy vấn tùy chỉnh ở đây nếu muốn
    @Modifying
    @Transactional
    @Query("DELETE FROM Order o WHERE o.customer IS NULL OR o.product IS NULL")
    void deleteInvalidOrders();
}