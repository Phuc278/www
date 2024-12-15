package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.services.company;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.enums.EnumModel;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.ids.JobSkill_Id;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.*;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.repositories.*;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.models.PhanHoiVaIdCom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private Company_Repositories company_repositories;
    @Autowired
    private UserPassCom_Repository userPassCom_repository;
    @Autowired
    private Company company;
    @Autowired
    private Company company2;
    @Autowired
    private UserPassCompany userPassCom;
    @Autowired
    private PhanHoiVaIdCom phanHoiVaIdCom;
    @Autowired
    private JobSkill_Repositories jobSkill_repositories;
    @Autowired
    private JobSkill jobSkill;
    @Autowired
    private Job job;
    @Autowired
    private Skill skill;
    @Autowired
    private Job_Repositories job_repositories;
    @Autowired
    Skill_Repositories skill_repositories;
    @Autowired
    JobSkill_Id jobSkill_id;

    public String addCompany(UserPassCompany userPassCompany) {
        company = company_repositories.findByPhone(userPassCompany.getCompany().getPhone());
        company2 = company_repositories.findByEmail(userPassCompany.getCompany().getEmail());
        userPassCom = userPassCom_repository.findByUserName(userPassCompany.getUserName());
        //Kiem tra xem cong ty da co dang ky bang email va sdt chua
        if (company != null || company2 != null) { //Neu 1 trong 2 da co thi tra ve EmailAndPhoneNotOke
            return "EmailAndPhoneNotOke";
        } else if (userPassCom != null) { //Kiem tra xem ten tai khoan da co chua
            return "UserNotOk";
        } else { //Neu chua co thi luu Compnay vao truoc sao do lay id ra set vao UserPassCompany va luu vao databse
            company_repositories.save(userPassCompany.getCompany());
            userPassCompany.setCompany(company_repositories.
                    findByPhoneAndEmail(userPassCompany.getCompany().getPhone(),
                            userPassCompany.getCompany().getEmail()));
            userPassCom_repository.save(userPassCompany);
            return "Ok";
        }
    }

    public PhanHoiVaIdCom LoginCompany(UserPassCompany userPassCompany) {
        userPassCom = userPassCom_repository
                .findByUserNameAndPassword(userPassCompany.getUserName(), userPassCompany.getPassword());
        if (userPassCom == null) {
            phanHoiVaIdCom.setPhanHoi("UserPassNotOk");
            return phanHoiVaIdCom;
        }
        phanHoiVaIdCom.setId(userPassCom.getCompany().getId());
        phanHoiVaIdCom.setPhanHoi("Ok");
        return phanHoiVaIdCom;
    }

    public List<String> listSkillLevel() {
        List<String> listSkillLevel = new ArrayList<>();
        listSkillLevel.add(EnumModel.SkillLevel.MASTER.toString());
        listSkillLevel.add(EnumModel.SkillLevel.BEGINNER.toString());
        listSkillLevel.add(EnumModel.SkillLevel.ADVANCED.toString());
        listSkillLevel.add(EnumModel.SkillLevel.PROFESSIONAL.toString());
        listSkillLevel.add(EnumModel.SkillLevel.IMTEMEDIATE.toString());
        return listSkillLevel;
    }

    public void themJob(Job job) {
        System.out.println("da Them Job");
        job_repositories.save(job);
    }


    public long themJobSkill(Long taoJobId, Long IdCompany, JobSkill jobSkilla) {
        Company com1 = new Company();
        com1.setId(IdCompany);
        //Neu la -1 thi tao moi khong6 thi tiep tuc
        Job job1 = new Job();
        if (-1 == taoJobId) {
            job1.setId(null);
            job1.setCompany(com1);
            job1 = job_repositories.save(job1);
            System.out.println("Cong viec -1");
        } else {
            job1 = job_repositories.findById(taoJobId).get();
            System.out.println("Cong viec khac -1 232");
        }

        Long idJob = job1.getId();
        System.out.println("idJob sau khi  ra if else " + idJob);
        JobSkill_Id js_id = new JobSkill_Id();
        js_id.setJobId(idJob);
        js_id.setSkillId(jobSkilla.getSkill().getId());
        jobSkilla.setId(js_id);
        jobSkilla.setJob(job1);
        System.out.println("jobskill" + jobSkilla);
        jobSkill_repositories.save(jobSkilla);
        return idJob;
    }

    public List<JobSkill> listJobSkill(Long JobId) {
        return jobSkill_repositories.TimJobSkillBangIdCongTyVaIdSkill(JobId);
    }

    public List<Job> listJob(Long idCom) {
        return job_repositories.danhSachTatCaJobKhongCoTen(idCom);

    }
}
