package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Scope("prototype")
public class UserPassCandidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    private String userName;
    private String password;

    public UserPassCandidate(Candidate candidate, String userName, String password) {
        this.candidate = candidate;
        this.userName = userName;
        this.password = password;
    }

    public UserPassCandidate(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

}
