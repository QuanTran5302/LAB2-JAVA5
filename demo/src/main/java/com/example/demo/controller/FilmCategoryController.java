package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Film;
import com.example.demo.entity.FilmCategory;
import com.example.demo.entity.Language;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.FilmCategoryRepository;
import com.example.demo.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FilmCategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    FilmCategoryRepository filmCategoryRepository;

    @GetMapping("list-FilmCategory")
    public String showFilmCategory(Model model){
        List<FilmCategory> listFilmCate = filmCategoryRepository.getAll();
        model.addAttribute("listFilmCate",listFilmCate);
        return "Lab4/FilmCategory/list_FilmCategory";
    }
    @GetMapping("add-filmCategory")
    public  String showAdd(Model model){
        model.addAttribute("filmCategory",new FilmCategory());
        List<Film> listFilm = filmRepository.getAll();
        model.addAttribute("listFilm",listFilm);
        List<Category> listCategory = categoryRepository.getAll();
        model.addAttribute("listCategory",listCategory);
        return "Lab4/FilmCategory/AddFilmCategory";
    }
    @PostMapping("add-filmCategory")
    public String AddFilmCategory(@ModelAttribute("filmCategory") FilmCategory filmCategory){
        filmCategoryRepository.save(filmCategory);
        return "redirect:list-FilmCategory";
    }
}
