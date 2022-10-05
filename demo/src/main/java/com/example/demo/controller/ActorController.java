package com.example.demo.controller;

import com.example.demo.entity.Actor;
import com.example.demo.entity.Category;
import com.example.demo.entity.Film;
import com.example.demo.entity.Language;
import com.example.demo.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ActorController {
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    HttpServletRequest req;

    @GetMapping("list-actor")
    public String showActor(Model model){
        String name = req.getParameter("tukhoa");
        if (name == null){
            List<Actor> listac = actorRepository.getAll();
        model.addAttribute("listac",listac);
        }
        else {
            int a = Integer.parseInt(name);
            List<Actor> listac = actorRepository.getactorByName(a);
            model.addAttribute("listac", listac);
        }
        return "Lab4/Actor/list_Actor";
    }
    @GetMapping("add-Actor")
    public  String showAdd(Model model){
        model.addAttribute("actor",new Actor());
        return "Lab4/Actor/addActor";
    }
    @PostMapping("add-Actor")
    public String AddActor(@ModelAttribute("actor") Actor actor){
        actorRepository.save(actor);
        return "redirect:list-actor";
    }
}
