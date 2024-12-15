package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.cotrollers.post.candidate;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.CandidateSkill;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.UserPassCandidate;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.services.candidate.CandidateService;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.models.PhanHoiVaIdCan;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/Candidate")
public class PostCandidateController {
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private UserPassCandidate userPassCandidate;
    @Autowired
    private PhanHoiVaIdCan phanHoiVaIdCan;

    @PostMapping("/SaveCandidate")
    public String saveCandidate(@ModelAttribute (value = "userPassCandidate") UserPassCandidate userPass, RedirectAttributes redirectAttributes){

         String phanHoi =candidateService.luuThongTinCandidate(userPass);
         if (!phanHoi.equals("Ok")){
             redirectAttributes.addFlashAttribute("userPassCandidate", userPass);
                return "redirect:/Candidate/SignUp?error="+phanHoi;
         }

        return "redirect:/Candidate/Login";
    }

    @PostMapping("/checkUserPass")
    public String checkLogin(@ModelAttribute (value = "userPassCan") UserPassCandidate userPassCan, HttpSession session){
        phanHoiVaIdCan = candidateService.checkLogin(userPassCan);
        String phanHoi = phanHoiVaIdCan.getPhanHoi();

        if ( !phanHoi.equals("Ok")){
            return "redirect:/Candidate/Login?error="+phanHoi;
        }
        session.setAttribute("idCan", phanHoiVaIdCan.getIdCan());
        return "redirect:/Candidate/Home";
    }

    @PostMapping("/SaveUpdateCanSkill")
    public String saveUpdateSkill(@ModelAttribute (value = "candidateSkill")CandidateSkill canSkill, HttpSession session){
        candidateService.luuThongTinSkill(canSkill, (long) session.getAttribute("idCan"));
        return "redirect:/Candidate/UpdateSkill";
    }
}
