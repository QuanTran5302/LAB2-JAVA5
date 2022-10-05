package com.example.demo.controller;

import com.example.demo.entity.Actor;
import com.example.demo.entity.Film;
import com.example.demo.entity.FilmActor;
import com.example.demo.repository.ActorRepository;
import com.example.demo.repository.FilmActorRpository;
import com.example.demo.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FilmActorController {
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    FilmActorRpository filmActorRpository;


    @GetMapping("list-filmactor")
    public String showFilmActor(Model model){
        List<FilmActor> listfilmActor = filmActorRpository.getAll();
        model.addAttribute("listfilmActor",listfilmActor);
        return "Lab4/FilmActor/list_filmactor";
    }
    @GetMapping("add-filmActor")
    public  String showAdd(Model model){
        model.addAttribute("filmActor",new FilmActor());
        List<Film> listFilm = filmRepository.getAll();
        model.addAttribute("listFilm",listFilm);
        List<Actor> ListActor = actorRepository.getAll();
        model.addAttribute("ListActor",ListActor);
        return "Lab4/FilmActor/addfilmActor";
    }
    @PostMapping("add-filmActor")
    public String AddFilmActor(@ModelAttribute("filmActor") FilmActor filmActor){
        filmActorRpository.save(filmActor);
        return "redirect:list-filmactor";
    }
}
