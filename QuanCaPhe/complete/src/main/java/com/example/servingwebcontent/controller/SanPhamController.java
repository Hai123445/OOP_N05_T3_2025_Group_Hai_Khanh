/* 
package com.example.demo.controller;

import com.example.demo.dao.SanPhamDAO;
import com.example.demo.model.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/sanphams")
public class SanPhamController {
    @Autowired
    private SanPhamDAO dao;

    @GetMapping
    public List<SanPham> getAll() throws SQLException {
        return dao.getAll();
    }

    @GetMapping("/{id}")
    public SanPham getById(@PathVariable int id) throws SQLException {
        return dao.getById(id);
    }

    @PostMapping
    public void add(@RequestBody SanPham sp) throws SQLException {
        dao.insert(sp);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody SanPham sp) throws SQLException {
        dao.update(id, sp);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws SQLException {
        dao.delete(id);
    }
}
    */