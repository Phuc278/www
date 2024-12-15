package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.ids;

import jakarta.persistence.Embeddable;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Embeddable
@Data //@Data, Lombok sẽ tự động tạo các phương thức getters, setters, equals(), hashCode() và toString()
@Component
@Scope("prototype")
public class CandidateSkill_Id implements Serializable {
    private Long skillId;
    private Long canId;
}
