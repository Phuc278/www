package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.cotrollers.get.candidate;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.Candidate;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.CandidateSkill;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.UserPassCandidate;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.services.candidate.CandidateService;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.models.JobVaListSkillDeXuat;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Candidate")
public class GetCandidateController {
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private JobVaListSkillDeXuat JobVaListSkillDeXuat;
    @Autowired
    private Candidate candidate;
    @Autowired
    private UserPassCandidate userPassCandidate;
    @Autowired
    private CandidateSkill candidateSkill;


    @GetMapping("/Home")
    public String trangChuCandidate(Model model, HttpSession session){
        Long idCan =(Long) session.getAttribute("idCan");
        List<JobVaListSkillDeXuat> jobVaListSkillDeXuatList = candidateService.danhsachJob(idCan);
        System.out.println(session.getAttribute("idCan"));
        model.addAttribute("JobVaListSkillDeXuat", jobVaListSkillDeXuatList);
        return "candidate/CandidateHomePage";
    }

    @GetMapping("/JobSkillDetail")
    public String getJobSkillDetail(){
        return "candidate/JobSkillDetail";
    }
    @GetMapping("/SignUp")
    public String getSignUp(Model model){
        model.addAttribute("userPassCandidate", userPassCandidate );
        return "candidate/SignUpCandidate";
    }
    @GetMapping("/Login")
    public String getLogin(Model model){
        model.addAttribute("userPassCan", userPassCandidate);
        return "candidate/LoginCandidate";
    }
    @GetMapping("/UpdateSkill")
    public String getUpdateSkill(Model model, HttpSession session){
        model.addAttribute("listSkill", candidateService.listSkill());
        model.addAttribute("candidateSkill", candidateSkill);
        model.addAttribute("listSkillLevel", candidateService.listSkillLevel());
        model.addAttribute("listCandidateSkill", candidateService.listCandidateSkill( (long) session.getAttribute("idCan")));
        return "candidate/UpdateCandidateSkill";
    }

    @GetMapping("/JobRecoment")
    public String getJobRecoment(Model model, HttpSession session){
        model.addAttribute("listJobRecomment", candidateService.listJobDeXuat((long) session.getAttribute("idCan")));
        return "candidate/JobRecoment";
    }
}
