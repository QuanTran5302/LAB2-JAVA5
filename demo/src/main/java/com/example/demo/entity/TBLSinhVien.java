package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class TBLSinhVien {
    @Id
    @Column(name = "MASV")
    private Integer MaSv;

    @Column(name = "HOTENSV")
    private String HoTenSv;

    @Column(name = "MAKHOA")
    private String Makhoa;

    @Column(name = "NAMSINH")
    private Integer Namsinh;

    @Column(name = "QUEQUAN")
    private String QueQuan;

}
