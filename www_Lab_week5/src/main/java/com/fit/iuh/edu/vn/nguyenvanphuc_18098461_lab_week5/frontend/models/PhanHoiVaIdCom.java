package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhanHoiVaIdCom {
    private String phanHoi;
    private long id;
}
