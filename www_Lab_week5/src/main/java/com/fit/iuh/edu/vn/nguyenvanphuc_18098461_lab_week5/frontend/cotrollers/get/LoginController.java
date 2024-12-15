package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.cotrollers.get;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Login")
public class LoginController {

    @GetMapping("/Option")
    public String DangNhapLuaChon(Model model, HttpSession session){
        model.addAttribute("Hello", "Hello from the orther side");
        session.setAttribute("idCan", (long)-1);
        return "/LoginOption";
    }



}
