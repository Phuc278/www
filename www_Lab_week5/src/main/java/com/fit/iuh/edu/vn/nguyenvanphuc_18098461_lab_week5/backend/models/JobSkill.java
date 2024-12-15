package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.enums.EnumModel;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.ids.JobSkill_Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Scope("prototype")
public class JobSkill {
    @EmbeddedId
    private JobSkill_Id id;
    @Enumerated(EnumType.STRING) //Khai báo là Enum và lưu vao data la String
    private EnumModel.SkillLevel skillLevel;
    @ManyToOne
    @MapsId ("jobId") // ánh xạ qua trường jobId bên class JobKill_Id
    @JoinColumn(name ="job_id")
    private Job job;
    private String moreInfo;
    @ManyToOne
    @MapsId("skillId") // ánh xạ qua trường skillId bên class JobKill_Id
    @JoinColumn(name = "skill_id")
    private Skill skill;

    public JobSkill(EnumModel.SkillLevel skillLevel, Job job, String moreInfo, Skill skill) {
        this.skillLevel = skillLevel;
        this.job = job;
        this.moreInfo = moreInfo;
        this.skill = skill;
    }

    public JobSkill(JobSkill_Id id, EnumModel.SkillLevel skillLevel, String moreInfo, Skill skill) {
        this.id = id;
        this.skillLevel = skillLevel;
        this.moreInfo = moreInfo;
        this.skill = skill;
    }
}
