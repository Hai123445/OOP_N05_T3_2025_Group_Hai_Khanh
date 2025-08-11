package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.MenuItem;
import com.example.servingwebcontent.model.NhanVien;
import com.example.servingwebcontent.model.Order;
import com.example.servingwebcontent.repository.MenuItemRepository;
import com.example.servingwebcontent.repository.NhanVienRepository;
import com.example.servingwebcontent.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private MenuItemRepository menuRepo;

    @Autowired
    private NhanVienRepository nhanVienRepo;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestParam Long nhanVienId,
                                             @RequestParam Long menuItemId,
                                             @RequestParam int quantity) {
        NhanVien nv = nhanVienRepo.findById(nhanVienId).orElse(null);
        MenuItem item = menuRepo.findById(menuItemId).orElse(null);

        if (nv == null || item == null) {
            return ResponseEntity.badRequest().build();
        }

        Order order = new Order();
        order.setNhanVien(nv);
        order.setMenuItem(item);
        order.setQuantity(quantity);

        return ResponseEntity.ok(orderRepo.save(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        if (orderRepo.existsById(id)) {
            orderRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
