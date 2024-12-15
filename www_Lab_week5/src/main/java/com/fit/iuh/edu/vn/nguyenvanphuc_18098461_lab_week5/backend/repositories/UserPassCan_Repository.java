package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.repositories;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.UserPassCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPassCan_Repository extends JpaRepository<UserPassCandidate, Long> {
    UserPassCandidate findByUserName(String username);
    UserPassCandidate findByUserNameAndPassword(String userName, String password);
}
