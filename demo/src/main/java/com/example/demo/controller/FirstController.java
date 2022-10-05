package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FirstController {
//    @Autowired(required = true)
//    KhoaRepository khoaRepository;
//
//    @Autowired
//    DeTaiRepository deTaiRepository;
//
//    @Autowired
//    GiangVienRepository giangVienRepository;
//
//    @Autowired
//    SinhVienRepository sinhVienRepository;
//
//    @Autowired
//    HuongDanRepository huongDanRepository;
//
//    @GetMapping("/khoa")
//    public String getAllKhoa(Model model) {
//        List<TBLKhoa> listKhoa = khoaRepository.getAll();
//        model.addAttribute("listKhoa", listKhoa);
//        return "khoa";
//    }
//
//    @GetMapping("/deTai")
//    public String getAllDeTai(Model model) {
//        List<TBLDeTai> listDeTai = deTaiRepository.getAll();
//        model.addAttribute("listDeTai", listDeTai);
//        return "deTai";
//    }
//
//    @GetMapping("/giangVien")
//    public String getAllGiangVien(Model model) {
//        List<TBLGiangVien> listGV = giangVienRepository.getAll();
//        model.addAttribute("listGV", listGV);
//        return "giangVien";
//    }
//
//    @GetMapping("/sinhVien")
//    public String getAllSinhVien(Model model) {
//        List<TBLSinhVien> listSinhVien = sinhVienRepository.getAll();
//        model.addAttribute("listSinhVien", listSinhVien);
//        return "sinhVien";
//    }
//
//    @GetMapping("/huongDan")
//    public String getAllHuongDan(Model model) {
//        List<TBLHuongDan> listHD = huongDanRepository.getAll();
//        model.addAttribute("listHD", listHD);
//        return "huongDan";
//    }

//
//    @Autowired
//    CategoryRepository categoryRepository;
//
//    @GetMapping("list_cate")
//    public String showcate(Model model){

//        List<CategoryEntity> listcate = categoryRepository.getAll();
//            model.addAttribute("listcate",listcate);
//        String name = "a";
//        List<Category> listcate = categoryRepository.getAll();
//        model.addAttribute("listcate",listcate);
//        return "listCategory";
//    }



}
