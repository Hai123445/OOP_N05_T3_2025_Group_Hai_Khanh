package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.MenuItem;
import com.example.servingwebcontent.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuItemController {

    @Autowired
    private MenuItemRepository repo;

    @GetMapping
    public List<MenuItem> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public MenuItem create(@RequestBody MenuItem item) {
        return repo.save(item);
    }

    @PutMapping("/{id}")
    public MenuItem update(@PathVariable Long id, @RequestBody MenuItem updated) {
        return repo.findById(id).map(item -> {
            item.setName(updated.getName());
            item.setPrice(updated.getPrice());
            return repo.save(item);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String status = body.get("status");
        if (status == null || !(status.equalsIgnoreCase("Còn") || status.equalsIgnoreCase("Hết"))) {
            return ResponseEntity.badRequest().body("Trạng thái chỉ được là 'Còn' hoặc 'Hết'");
        }

        MenuItem item = repo.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy món với id: " + id));
        item.setStatus(status);
        repo.save(item);
        return ResponseEntity.ok(item);
    }
}