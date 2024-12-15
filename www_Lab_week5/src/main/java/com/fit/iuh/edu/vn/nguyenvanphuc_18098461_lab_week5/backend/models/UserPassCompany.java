package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Scope("prototype")
public class UserPassCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "com_id")
    private Company company;
    private String userName;
    private String password;

    public UserPassCompany(String userName, Company company, String password) {
        this.userName = userName;
        this.company = company;
        this.password = password;
    }

    public UserPassCompany(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
