package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.cotrollers.get.company;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.Job;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.JobSkill;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.services.company.CompanyService;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.services.skill.SkillService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/Company")
public class CompanyController {
    @Autowired
    private JobSkill jobSkill;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private Job job;
    @Autowired
    private SkillService skillService;


    @GetMapping("/Home")
    public String home(@RequestParam(value = "ad",required = false) String ad, Model model){
        if (ad != null){
            model.addAttribute("ad", ad);
        }
        return "company/CompanyHome";
    }

    @GetMapping("/AddJob")
    public String addJob(
                         HttpSession session,
                         Model model, RedirectAttributes redirectAttributes){


        model.addAttribute("jobSkill",jobSkill  );
        model.addAttribute("listSkillLevel",companyService.listSkillLevel());
        model.addAttribute("listSkill", skillService.listSkill());
        model.addAttribute("job",job);
        Long IdCompany = (Long) session.getAttribute("IdCompany");
        model.addAttribute("listJob",companyService.listJob(IdCompany));

        Long jobId = (Long) session.getAttribute("taoJobId");
        if (jobId != -1)
            model.addAttribute("listJobSkill",companyService.listJobSkill(jobId));
        else
            model.addAttribute("listJobSkill",null);
        return "company/CompanyAddJob";
    }
}
