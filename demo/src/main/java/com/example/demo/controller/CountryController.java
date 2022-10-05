package com.example.demo.controller;

import com.example.demo.entity.Actor;
import com.example.demo.entity.Country;
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
public class CountryController {

    @Autowired
    CountryRepository countryRepository;
    @Autowired
    HttpServletRequest req;
    @GetMapping("list-country")
    public String showCountry(Model model){
        String name = req.getParameter("tukhoa");
        if (name == null){
            List<Country> listCountry = countryRepository.getAll();
            model.addAttribute("listCountry",listCountry);

        }
        else {
            List<Country> listCountry = countryRepository.getCountryByName('%' + name + '%');
            model.addAttribute("listCountry", listCountry);
        }
        return "Lab4/Country/list_Country";
    }
    @GetMapping("add-Country")
    public  String showAdd(Model model){
        model.addAttribute("country",new Country());
        return "Lab4/Country/addCountry";
    }
    @PostMapping("add-Country")
    public String AddCountry(@ModelAttribute("country") Country country){
        countryRepository.save(country);
        return "redirect:list-country";
    }
}
