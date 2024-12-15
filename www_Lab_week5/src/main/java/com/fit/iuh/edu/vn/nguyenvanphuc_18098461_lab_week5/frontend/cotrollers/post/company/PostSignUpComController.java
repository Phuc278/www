package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.cotrollers.post.company;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.UserPassCompany;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.services.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/SignUp")
public class PostSignUpComController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/SaveCompany")
    public String dangKyCongTy(@ModelAttribute("userPassCompany") UserPassCompany userPassCompany, RedirectAttributes redirectAttributes) {
        String phanHoi = companyService.addCompany(userPassCompany);
        if (!phanHoi.equals("Ok")){
            redirectAttributes.addFlashAttribute("phanHoi", phanHoi);
            redirectAttributes.addFlashAttribute("userPassCompany", userPassCompany);
            return "redirect:/SignUp/Company";
        }

        return "redirect:/Login/Company"; //Chuyen toi trang Dang nhap cua cong ty

    }
}
