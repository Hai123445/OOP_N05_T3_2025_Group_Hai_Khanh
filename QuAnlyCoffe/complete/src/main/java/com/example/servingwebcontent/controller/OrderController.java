package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Order;
import com.example.servingwebcontent.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository repo;

    @GetMapping
    public List<Order> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        order.setCreatedAt(LocalDateTime.now());
        return repo.save(order);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order updated) {
        return repo.findById(id).map(o -> {
            o.setCustomerName(updated.getCustomerName());
            o.setTotalAmount(updated.getTotalAmount());
            return repo.save(o);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
