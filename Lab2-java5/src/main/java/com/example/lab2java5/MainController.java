package com.example.lab2java5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("bai1")
    public String bai1(@RequestParam(name = "str1") String str1, @RequestParam(name = "str2") String str2, Model model) {
        if (str1.equals("")) {
            model.addAttribute("message", "Bạn chưa nhập chuỗi 1");
        } else if (str2.equals("")) {
            model.addAttribute("message", "Bạn chưa nhập chuỗi 2");
        } else if (str1.length() > str2.length()) {
            model.addAttribute("message", "Chuỗi 1 dài hơn: " + str1);
        } else if (str1.length() < str2.length()) {
            model.addAttribute("message", "Chuỗi 2 dài hơn: " + str2);
        } else {
            model.addAttribute("message", "2 Chuỗi bằng nhau");
        }
        return "bai1";
    }

    @GetMapping("bai2")
    public String bai2(@RequestParam(name = "str") String str, Model model) {
        if (str.equals("")) {
            model.addAttribute("message", "Bạn chưa nhập chuỗi");
        } else {
            String dl = new StringBuffer(str).reverse().toString();
            model.addAttribute("message", "Chuỗi đảo ngược: " + dl);
        }
        return "bai2";
    }

    @GetMapping("bai3")
    public String bai3(@RequestParam(name = "number") Integer number, Model model) {
        if (number < 2) {
            model.addAttribute("message", 2);
        } else {
            int a = number + 1;
            while (!isPrimeNumber(a)) {
                a++;
            }

            model.addAttribute("message", a);
        }
        return "bai3";
    }

    public static boolean isPrimeNumber(int n) {
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
