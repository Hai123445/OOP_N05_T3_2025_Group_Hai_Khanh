package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingControllerNV {

    @GetMapping("/")
    public String QLNV(Model model) {
        model.addAttribute("title", "Hệ thống quản lý");
        model.addAttribute("welcomeMessage", "Chào mừng bạn đến với hệ thống quản lý nhân viên!");
        return "indexNV"; // Trả về file indexNV.html
    }
}

