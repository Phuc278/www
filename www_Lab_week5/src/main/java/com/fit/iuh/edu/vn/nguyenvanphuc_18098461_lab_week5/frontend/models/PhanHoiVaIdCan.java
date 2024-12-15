package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class PhanHoiVaIdCan {
    String phanHoi;
    Long idCan;
}
