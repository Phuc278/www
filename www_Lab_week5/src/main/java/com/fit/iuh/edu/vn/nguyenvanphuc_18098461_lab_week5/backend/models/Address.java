package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.models;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
//tạo ra một bean mới mỗi lần được yêu cầu
// nghĩa là gọi hàm có chứa đối tượng này thì mỗi lần gọi hàm thì tao5 mới đối tượng
//chứ ko phải là tạo một đối tượng duy nhất và sử dụng nó cho tất cả các lần gọi hàm
//chỉ thay đổi giá trị của nó tránh lỗi là hibernate xác nhận là sử dụng 1 đối tượng này cho
//nhiều đối tượng khác nhau
@Scope("prototype")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private Long id;
    private String city;
    @Enumerated(EnumType.STRING)
    private CountryCode country;
    private String zipcode;
    private String street;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
    private Candidate candidate;
    private String number;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
    private Company company;
}
