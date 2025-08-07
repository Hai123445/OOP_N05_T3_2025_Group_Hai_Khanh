package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Promo;
import com.example.servingwebcontent.repository.PromoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promos")
public class PromoController {

    @Autowired
    private PromoRepository repo;

    @GetMapping
    public List<Promo> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Promo create(@RequestBody Promo promo) {
        return repo.save(promo);
    }

    @PutMapping("/{id}")
    public Promo update(@PathVariable Long id, @RequestBody Promo updated) {
        return repo.findById(id).map(p -> {
            p.setCode(updated.getCode());
            p.setDiscountPercentage(updated.getDiscountPercentage());
            return repo.save(p);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}