package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.backend.ids;

import jakarta.persistence.Embeddable;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Embeddable //the hien day la mot class chua cac field cua mot class khac va class duoc nhung phai su dung @Embedded va trong co so du lieu se duoc hien thi thanh mot bang va co chua cac field cua class nay
@Data
@Component
@Scope("prototype")
public class JobSkill_Id implements Serializable {
    private Long jobId;
    private Long skillId;
}
