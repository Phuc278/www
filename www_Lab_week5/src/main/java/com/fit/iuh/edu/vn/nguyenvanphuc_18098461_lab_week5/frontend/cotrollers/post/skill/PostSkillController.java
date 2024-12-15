package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.cotrollers.post.skill;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.Skill;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.services.skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Skill")
public class PostSkillController {
    @Autowired
    private Skill skill;
    @Autowired
    private SkillService skillService;

    @PostMapping("/SaveSkill")
    public String addSkill(@ModelAttribute("skill") Skill skill){
        skillService.saveSkill(skill);
        return "redirect:/Skill/AddSkill";
    }
}
