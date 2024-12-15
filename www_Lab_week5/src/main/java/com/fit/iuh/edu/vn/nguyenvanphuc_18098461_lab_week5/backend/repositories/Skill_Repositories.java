package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.repositories;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Skill_Repositories extends JpaRepository<Skill, Long> {
}
