package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CatgoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    HttpServletRequest req;

    @GetMapping("list_cate")
    public String showcate(Model model) {
//        String name = "t";
//        List<Category> listcate = categoryRepository.getAll();
        String name = req.getParameter("tukhoa");
        List<Category> listcate = categoryRepository.getcategoryByName('%'+ name+ '%');
        model.addAttribute("listcate", listcate);
        return "listCategory";
    }
    @GetMapping("add-cate")
    public  String showAdd(Model model){
        model.addAttribute("category",new Category());
        return "addCategory";
    }
    @PostMapping("add-cate")
    public String AddCategory(@ModelAttribute("category") Category category){
        categoryRepository.save(category);
        return "redirect:list_cate";
}
}
