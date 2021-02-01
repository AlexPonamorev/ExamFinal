package com.example.demo.controller;

import com.example.demo.entity.PersonForm;
import com.example.demo.service.UniversalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/suggestH")
public class ControllerHtml {

    @Autowired
    UniversalService universalService;


    @GetMapping("/")
    public String select(Model model) {
        Map<String, String> BM = new HashMap<>();

        try {
            BM = universalService.getMapBrand();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PersonForm form = new PersonForm();
        model.addAttribute("personForm", form);

        model.addAttribute("BM", BM);
        return "BM"; // вернет  страницу - index.html которая лежит в папке template
        // если папка лежит в паке default то пишем "default/index"
    }
}
