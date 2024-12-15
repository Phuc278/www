package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.repositories;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.JobSkill;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.ids.JobSkill_Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSkill_Repositories extends JpaRepository<JobSkill, JobSkill_Id> {
    @Query("SELECT js FROM JobSkill js " +
            "JOIN js.job j " +
            "WHERE j.id = :idJob")
    List<JobSkill> TimJobSkillBangIdCongTyVaIdSkill(@Param("idJob") Long JobId);
}
