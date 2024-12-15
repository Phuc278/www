package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.nodes.ScalarNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Scope("prototype")
public class Candidate {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name ="can_id")
    private Long id;
    private String phone;
    private LocalDate dob;
    private String email;
    private String fullName;
    @OneToOne
    @JoinColumn(name = "address")
    private Address address;;
    @OneToMany(mappedBy = "candidate")
    private List<CandidateSkill> candidateSkills;
    @OneToMany(mappedBy = "candidate")
    private List<Experience> experiences;
    @OneToOne(mappedBy = "candidate")
    private UserPassCandidate userPassCandidate;

    public Candidate(Long id) {
        this.id = id;
    }

    public Candidate(String fullName, String email, String phone) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }
}
