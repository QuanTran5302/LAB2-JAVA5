package com.example.demo.controller;

import com.example.demo.entity.Actor;
import com.example.demo.entity.Language;
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
public class LanguageController {
    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    HttpServletRequest req;
    @GetMapping("list-language")
    public String showLanguage(Model model){
        String name = req.getParameter("tukhoa");
        if (name == null){
            List<Language> listLanguage = languageRepository.getAll();
            model.addAttribute("listLanguage",listLanguage);
        }
        else {
            List<Language> listLanguage = languageRepository.getLanguageByName('%' + name + '%');
            model.addAttribute("listLanguage", listLanguage);
        }

        return "Lab4/Language/list_language";
    }
    @GetMapping("add-language")
    public  String showAdd(Model model){
        model.addAttribute("language",new Language());
        return "Lab4/Language/addLanguage";
    }
    @PostMapping("add-language")
    public String AddLanguage(@ModelAttribute("language") Language language){
        languageRepository.save(language);
        return "redirect:list-language";
    }
}
