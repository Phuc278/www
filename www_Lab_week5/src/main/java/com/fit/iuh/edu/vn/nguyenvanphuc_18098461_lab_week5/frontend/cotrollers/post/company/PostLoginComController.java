package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.cotrollers.post.company;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.UserPassCompany;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.services.company.CompanyService;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.models.PhanHoiVaIdCom;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/Login")
public class PostLoginComController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private PhanHoiVaIdCom phanHoiVaIdCom;
    @PostMapping("/CompanyHome")
    public String dangNhapCuaCongTy(HttpSession session, @ModelAttribute ("userPassCompany")UserPassCompany userPassCompany, RedirectAttributes redirectAttributes){
        phanHoiVaIdCom = companyService.LoginCompany(userPassCompany);
        String phanHoi = phanHoiVaIdCom.getPhanHoi();
        if (!phanHoi.equals("Ok"))
            return "redirect:/Login/Company?error="+phanHoi;
        redirectAttributes.addFlashAttribute("ad", phanHoiVaIdCom.getId());
        Long taoJobId = (long) -1;
        session.setAttribute("taoJobId",taoJobId);
        session.setAttribute("IdCompany",phanHoiVaIdCom.getId());//Id cua3 company
        return "redirect:/Company/Home?ad="+phanHoiVaIdCom.getId();
    }
}
