package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.MenuItem;
import com.example.servingwebcontent.model.NhanVien;
import com.example.servingwebcontent.model.Order;
import com.example.servingwebcontent.repository.MenuItemRepository;
import com.example.servingwebcontent.repository.NhanVienRepository;
import com.example.servingwebcontent.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private MenuItemRepository productRepo;

    @Autowired
    private NhanVienRepository nhanVienRepo;

    // Hiển thị danh sách đơn hàng
    @GetMapping
    public String getAllOrders(Model model) {
        List<Order> orders = orderRepo.findAll();
        double tongTien = orders.stream()
                .mapToDouble(o -> o.getProduct().getPrice() * o.getSoLuong())
                .sum();

        model.addAttribute("orders", orders);
        model.addAttribute("tongTien", tongTien);
        model.addAttribute("products", productRepo.findAll());
        model.addAttribute("nhanViens", nhanVienRepo.findAll());

        return "orders"; // orders.html
    }

    // Thêm đơn hàng
    @PostMapping("/add")
    public String addOrder(@RequestParam Long productId,
                           @RequestParam Long nhanVienId,
                           @RequestParam int soLuong) {
        MenuItem product = productRepo.findById(productId).orElse(null);
        NhanVien nv = nhanVienRepo.findById(nhanVienId).orElse(null);

        if (product != null && nv != null && soLuong > 0) {
            Order order = new Order();
            order.setProduct(product);
            order.setNhanVien(nv);
            order.setSoLuong(soLuong);
            order.setOrderDate(LocalDate.now());
            orderRepo.save(order);
        }

        return "redirect:/orders";
    }

    // Xoá đơn hàng
    @PostMapping("/delete")
    public String deleteOrder(@RequestParam Long maDonHang) {
        if (orderRepo.existsById(maDonHang)) {
            orderRepo.deleteById(maDonHang);
        }
        return "redirect:/orders";
    }
}
