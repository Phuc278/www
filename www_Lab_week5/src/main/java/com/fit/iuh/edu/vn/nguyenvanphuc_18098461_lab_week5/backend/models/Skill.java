package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.enums.EnumModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Scope("prototype")
public class Skill {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name ="skill_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private EnumModel.SkillType type;
    private String skillName;
    private String skillDescription;
    @OneToMany(mappedBy = "skill")
    @ToString.Exclude // Ngăn lỗi vòng lặp toString
    private List<JobSkill> jobSkills;

    public Skill(EnumModel.SkillType type, String skillName, String skillDescription) {
        this.type = type;
        this.skillName = skillName;
        this.skillDescription = skillDescription;
    }

    public Skill(Long id) {
        this.id = id;
    }
}
