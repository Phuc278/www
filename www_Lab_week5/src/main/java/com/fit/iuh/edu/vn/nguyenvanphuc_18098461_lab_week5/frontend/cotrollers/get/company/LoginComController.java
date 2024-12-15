package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.cotrollers.get.company;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.UserPassCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Login")
public class LoginComController {
    @Autowired
    private UserPassCompany userPassCompany;

    @GetMapping("/Company")
    public String dangNhapCuaCongTy(Model model){
        model.addAttribute("signUp", "/SignUp/Company");
        model.addAttribute("userPassCompany",  userPassCompany);
        model.addAttribute("goCompanyHome", "/Login/CompanyHome");
        return "company/LoginCompany";
    }
}
