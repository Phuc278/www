package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.services.skill;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.enums.EnumModel;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.Skill;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.repositories.Skill_Repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService {
    @Autowired
    private Skill skill;
    @Autowired
    Skill_Repositories skill_repositories;

    public List<Skill> listSkill(){
        return skill_repositories.findAll();
    }

    public List<String> listSkillType(){
        List<String> listSkillType = new ArrayList<>();
        listSkillType.add(EnumModel.SkillType.SOFT_SKILL.toString());
        listSkillType.add(EnumModel.SkillType.UNSPECIFIC.toString());
        listSkillType.add(EnumModel.SkillType.TECHNICAL_SKILL.toString());

        return listSkillType;
    }

    public void saveSkill(Skill skill){
        skill_repositories.save(skill);
    }
}
