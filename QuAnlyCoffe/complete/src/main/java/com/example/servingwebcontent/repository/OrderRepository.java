package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
