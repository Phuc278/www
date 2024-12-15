package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.repositories;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Job_Repositories extends JpaRepository<Job,Long> {

    @Query("SELECT j FROM Job j WHERE j.name IS NOT NULL AND j.company.id = :idCom")
    List<Job> danhSachTatCaJobKhongCoTen(@Param("idCom") Long idCom);

    @Query("SELECT j " +
            "FROM Job j " +
            "JOIN JobSkill js ON j.id = js.job.id " +
            "JOIN CandidateSkill cs ON js.skill.id = cs.skill.id " +
            "WHERE cs.candidate.id = :idCan")
    List<Job> danhSachJobDeXuat(@Param("idCan") Long idCan);
}
