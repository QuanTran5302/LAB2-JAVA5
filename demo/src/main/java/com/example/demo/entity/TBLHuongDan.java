package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class TBLHuongDan {
    @Id
    @Column(name = "MASV")
    private Integer Masv;

    @Column(name = "MADT")
    private String MaDeTai;

    @Column(name = "MAGV")
    private Integer MaGV;

    @Column(name = "KETQUA")
    private BigDecimal KetQua;
}
