package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Scope("prototype")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;
    @OneToMany(mappedBy = "job")
    @ToString.Exclude // Ngăn lỗi vòng lặp toString
    private List<JobSkill> jobSkills;
    private String description;

    public Job(String name, Company company, String description) {
        this.name = name;
        this.company = company;
        this.description = description;
    }



    public Job(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Job(Long id) {
        this.id = id;
    }
}
