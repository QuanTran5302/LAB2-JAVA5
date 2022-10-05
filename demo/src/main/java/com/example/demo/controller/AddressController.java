package com.example.demo.controller;

import com.example.demo.entity.Actor;
import com.example.demo.entity.Address;
import com.example.demo.entity.City;
import com.example.demo.entity.Country;
import com.example.demo.repository.AddressRepository;
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
public class AddressController {
    @Autowired
    CityRepository cityRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    HttpServletRequest req;
    @GetMapping("list-address")
    public String showAddress(Model model){
//        List<Address> listAddress = addressRepository.getAll();
//        model.addAttribute("listAddress",listAddress);

        String name = req.getParameter("tukhoa");
        if (name == null){
            List<Address> listAddress = addressRepository.getAll();
            model.addAttribute("listAddress",listAddress);
        }
        else {
            List<Address> listAddress = addressRepository.getAddressByName('%' + name + '%');
            model.addAttribute("listAddress", listAddress);
        }


        return "Lab4/Address/list_Address";
    }
    @GetMapping("add-Address")
    public  String showAdd(Model model){
        model.addAttribute("address",new Address());
        List<City> listCity = cityRepository.getAll();
        model.addAttribute("listCity",listCity);
        return "Lab4/Address/addAddress";
    }
    @PostMapping("add-Address")
    public String AddAddress(@ModelAttribute("address") Address address){
        addressRepository.save(address);
        return "redirect:list-address";
    }
}
