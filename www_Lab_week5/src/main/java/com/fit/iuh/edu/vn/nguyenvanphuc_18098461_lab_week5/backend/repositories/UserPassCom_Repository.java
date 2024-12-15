package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.repositories;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPassCom_Repository extends JpaRepository<UserPassCompany, Long> {
    UserPassCompany findByUserName(String username);
    UserPassCompany findByUserNameAndPassword(String username, String password);
}
