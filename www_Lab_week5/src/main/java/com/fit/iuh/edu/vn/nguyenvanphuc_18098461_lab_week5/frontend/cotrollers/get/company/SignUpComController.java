package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.cotrollers.get.company;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.Company;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.UserPassCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/SignUp")
public class SignUpComController {
    @Autowired
    private UserPassCompany userPassCompany;
    @Autowired
    private Company company;

    @GetMapping("/Company")
    public String dangKyTaiKhoanCompany(Model model){
        model.addAttribute("userPassCompany", userPassCompany);
        model.addAttribute("saveSignUpCom","/SignUp/SaveCompany");
        return "/company/SignUpCompany";
    }
}
