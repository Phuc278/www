package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.repositories.Company_Repositories;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class TestCreate {

    @Autowired
    private Company_Repositories companyRepositories;

    @Test
    public void testSaveNewCompany() {
//        Company company = new Company("FPT", "cong ty FPT", "0123456789", "FPT.com", "FPT@gmail.com");
//
//        Company saveCompany = companyRepositories.save(company);
//
//        assertNotNull(saveCompany);
//        assertTrue(saveCompany.getJobs() == null || saveCompany.getJobs().isEmpty());
//        assertEquals("FPT", saveCompany.getName());
//        assertEquals("FPT.com", saveCompany.getWebURL());
    }
}
