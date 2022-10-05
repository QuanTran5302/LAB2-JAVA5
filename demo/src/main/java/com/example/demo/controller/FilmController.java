package com.example.demo.controller;

import com.example.demo.entity.Actor;
import com.example.demo.entity.Film;
import com.example.demo.entity.Language;
import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class FilmController {
    @Autowired
    FilmRepository filmRepository;

    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    HttpServletRequest req;
    @GetMapping("list-Film")
    public String showFilm(Model model){
        String name = req.getParameter("tukhoa");
        if (name == null){
            List<Film> listFilm = filmRepository.getAll();
            model.addAttribute("listFilm",listFilm);
        }
        else {
            List<Film> listFilm = filmRepository.getfilmByName(name);
            model.addAttribute("listFilm", listFilm);
        }

        return "Lab4/Film/list_Film";
    }
    @GetMapping("add-Film")
    public  String showAdd(Model model){
        model.addAttribute("film",new Film());
        List<Language> listLanguage = languageRepository.getAll();
        model.addAttribute("listLanguage",listLanguage);
        return "Lab4/Film/addFilm";
    }
    @PostMapping("add-Film")
    public String AddFilm(@ModelAttribute("film") Film film){
        filmRepository.save(film);
        return "redirect:list-Film";
    }
}
