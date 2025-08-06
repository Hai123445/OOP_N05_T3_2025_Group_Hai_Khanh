package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.servingwebcontent.service.GDService;

@Controller
public class GreetingController {
public GDService gdService;
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	@GetMapping("/dathang")
public String datHang(
    @RequestParam String masp,
    @RequestParam String nvgd,
    @RequestParam int tsp,
    @RequestParam double tt,
    Model model) {
    
    boolean ketqua = gdService.datHang(masp, nvgd, tsp, tt);
    model.addAttribute("result", ketqua ? "Đặt hàng thành công!" : "Đặt hàng thất bại. Mã sản phẩm không tồn tại.");
    return "dathang";
}

}
