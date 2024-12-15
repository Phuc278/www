package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.services.candidate;

import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.enums.EnumModel;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.ids.CandidateSkill_Id;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models.*;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.repositories.*;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.models.JobVaListSkillDeXuat;
import com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.models.PhanHoiVaIdCan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CandidateService {
    @Autowired
    private JobSkill jobSkill;
    @Autowired
    private JobSkill_Repositories jobSkill_repositories;
    @Autowired
    private UserPassCandidate userPassCandidate;
    @Autowired
    private Candidate candidate;
    @Autowired
    private UserPassCan_Repository userPassCan_repository;
    @Autowired
    private Candidate_Repositories candidate_repositories;
    @Autowired
    private PhanHoiVaIdCan phanHoiVaIdCan;
    @Autowired
    private JobVaListSkillDeXuat JobVaListSkillDeXuat;
    @Autowired
    private CandidateSkill candidateSkill;
    @Autowired
    private CandidateSkill_Repositories candidateSkill_repositories;
    @Autowired
    private Job job;
    @Autowired
    private Job_Repositories job_repositories;
    @Autowired
    private Skill_Repositories skill_repositories;
    @Autowired
    private CandidateSkill_Id candidateSkill_id;

    public List<JobVaListSkillDeXuat> danhsachJob(Long idCan){
        List<Job> jobList = job_repositories.findAll();
        List<JobVaListSkillDeXuat> jobVaListSkillDeXuatList = new ArrayList<>();
        List<CandidateSkill> canSkillList = candidateSkill_repositories.timCandidateSkillTheoCanId(idCan);

        if (idCan == -1){
            jobList.forEach(item -> jobVaListSkillDeXuatList.add(new JobVaListSkillDeXuat(item, null)));
            return jobVaListSkillDeXuatList;
        }else {
            candidate = candidate_repositories.findById(idCan).orElse(null);
            List<CandidateSkill> candidateSkills = candidate.getCandidateSkills();
            if (candidateSkills.isEmpty()){
                jobList.forEach(item -> jobVaListSkillDeXuatList.add(new JobVaListSkillDeXuat(item, null)));
                return jobVaListSkillDeXuatList;
            }
            //aasdfsa
            jobList.forEach(
                    jb -> {
                        JobVaListSkillDeXuat jbVaListDeXuat = new JobVaListSkillDeXuat();
                        jbVaListDeXuat.setJob(jb);

                        List<JobSkill> listSkillDeXuat = new ArrayList<>(jb.getJobSkills());
                        List<String> listSkillDeXuatString = new ArrayList<>();

                        canSkillList.forEach(
                                cs -> {
                                    listSkillDeXuat.removeIf(
                                            js1 -> Objects.equals(js1.getSkill().getId(), cs.getSkill().getId())
                                    );
                                }
                        );

                        listSkillDeXuat.forEach(canSkill -> listSkillDeXuatString.add(canSkill.getSkill().getSkillName()));

                        jbVaListDeXuat.setListSkillDeXuat(listSkillDeXuatString);
                        jobVaListSkillDeXuatList.add(jbVaListDeXuat);
                    }
            );
            return jobVaListSkillDeXuatList;

        }
    }

    public String luuThongTinCandidate(UserPassCandidate userPass) {
        userPassCandidate = userPassCan_repository.findByUserName(userPass.getUserName());
        if(userPassCandidate != null){
            return "UserNameNotOk";
        } else if (candidate_repositories.findByEmail(userPass.getCandidate().getEmail()) != null) {
            return "EmailNotOk";
        } else if (candidate_repositories.findByPhone(userPass.getCandidate().getPhone()) != null) {
            return "PhoneNotOk";
        }
        candidate = candidate_repositories.save(userPass.getCandidate());
        userPass.setCandidate(candidate);
        userPassCan_repository.save(userPass);
        return "Ok";
    }

    public PhanHoiVaIdCan checkLogin(UserPassCandidate userPassCan) {
        userPassCandidate = userPassCan_repository.findByUserNameAndPassword(userPassCan.getUserName(),userPassCan.getPassword());
        if ( userPassCandidate == null) {
            phanHoiVaIdCan.setPhanHoi("UserNameAndPasswordNotOk");
            return phanHoiVaIdCan;
        }

        phanHoiVaIdCan.setIdCan(userPassCandidate.getCandidate().getId());
        phanHoiVaIdCan.setPhanHoi("Ok");
        return phanHoiVaIdCan;
    }
    public List<Skill> listSkill(){
        return skill_repositories.findAll();
    }
    public List<String> listSkillLevel(){
        List<String> listSkillLevel = new ArrayList<>();
        listSkillLevel.add(EnumModel.SkillLevel.MASTER.toString());
        listSkillLevel.add(EnumModel.SkillLevel.BEGINNER.toString());
        listSkillLevel.add(EnumModel.SkillLevel.ADVANCED.toString());
        listSkillLevel.add(EnumModel.SkillLevel.PROFESSIONAL.toString());
        listSkillLevel.add(EnumModel.SkillLevel.IMTEMEDIATE.toString());
        return listSkillLevel;
    }

    public List<CandidateSkill> listCandidateSkill (Long idCan){
        return candidateSkill_repositories.timCandidateSkillTheoCanId(idCan);
    }

    public List<JobVaListSkillDeXuat> listJobDeXuat(Long idCan){
        List<JobVaListSkillDeXuat> jobVaListSkillDeXuatList = new ArrayList<>();
        List<CandidateSkill> canSkillList = candidateSkill_repositories.timCandidateSkillTheoCanId(idCan);
        job_repositories.danhSachJobDeXuat(idCan).forEach(
                jb -> {
                    JobVaListSkillDeXuat jbVaListDeXuat = new JobVaListSkillDeXuat();
                    jbVaListDeXuat.setJob(jb);

                    List<JobSkill> listSkillDeXuat = new ArrayList<>(jb.getJobSkills());
                    List<String> listSkillDeXuatString = new ArrayList<>();

                    canSkillList.forEach(
                            cs -> {
                                listSkillDeXuat.removeIf(
                                        js1 -> Objects.equals(js1.getSkill().getId(), cs.getSkill().getId())
                                );
                            }
                    );

                    listSkillDeXuat.forEach(canSkill -> listSkillDeXuatString.add(canSkill.getSkill().getSkillName()));

                    jbVaListDeXuat.setListSkillDeXuat(listSkillDeXuatString);
                    jobVaListSkillDeXuatList.add(jbVaListDeXuat);
                }
        );
        return jobVaListSkillDeXuatList;
    }

    public void luuThongTinSkill(CandidateSkill canSkill, long idCan) {
        candidateSkill_id.setCanId(idCan);
        candidateSkill_id.setSkillId(canSkill.getSkill().getId());
        canSkill.setId(candidateSkill_id);
        canSkill.setCandidate(new Candidate(idCan));
        candidateSkill_repositories.save(canSkill);
    }
}