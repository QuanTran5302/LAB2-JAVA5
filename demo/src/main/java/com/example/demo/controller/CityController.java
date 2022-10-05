package com.example.demo.controller;

import com.example.demo.entity.Actor;
import com.example.demo.entity.City;
import com.example.demo.entity.Country;
import com.example.demo.repository.ActorRepository;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CityController {
    @Autowired
    CityRepository cityRepository;

    @Autowired
    CountryRepository countryRepository;
    @Autowired
    HttpServletRequest req;

    @GetMapping("list-city")
    public String showCity(Model model){
        String name = req.getParameter("tukhoa");
        if (name == null){
            List<City> listCity = cityRepository.getAll();
            model.addAttribute("listCity",listCity);
        }
        else {
            List<City> listCity = cityRepository.getCityByName('%' + name + '%');
            model.addAttribute("listCity", listCity);
        }
        return "Lab4/City/list_City";
    }
    @GetMapping("add-City")
    public  String showAdd(Model model){
        model.addAttribute("city",new City());
        List<Country> listCountry = countryRepository.getAll();
        model.addAttribute("listCountry",listCountry);
        return "Lab4/City/addCity";
    }
    @PostMapping("add-City")
    public String AddCity(@ModelAttribute("city") City city){
        cityRepository.save(city);
        return "redirect:list-city";
    }
}
