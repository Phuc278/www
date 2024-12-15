package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.repositories;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Company_Repositories extends JpaRepository<Company,Long> {
    Company findByPhone(String phone);
    Company findByEmail(String email);
    Company findByPhoneAndEmail(String phone, String email);

}
