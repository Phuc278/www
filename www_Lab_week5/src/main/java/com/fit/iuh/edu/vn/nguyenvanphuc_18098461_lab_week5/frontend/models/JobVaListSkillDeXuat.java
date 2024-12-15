package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.models;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Scope("prototype")
public class JobVaListSkillDeXuat {

    private Job job;
    private List<String> listSkillDeXuat;;
}
