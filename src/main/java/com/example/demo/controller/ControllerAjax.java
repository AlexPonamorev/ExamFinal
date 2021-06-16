package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.RecommendationService;
import com.example.demo.service.ServiceAll;
import com.example.demo.service.UniversalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("/")
@Controller
public class ControllerAjax {

    private final RecommendationService recommendationService;
    private final ServiceAll serviceAll;
    private final UniversalService universalService;

    @Autowired
    public ControllerAjax(RecommendationService recommendationService, ServiceAll serviceAll, UniversalService universalService) {
        this.recommendationService = recommendationService;
        this.serviceAll = serviceAll;
        this.universalService = universalService;
    }


    @GetMapping
    public String brandController(org.springframework.ui.Model model){
       List<Brand> brandList = null;

        try {
            brandList = universalService.getBrandList();
            model.addAttribute("brandList", brandList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "indexSelect";
    }

    @GetMapping(value = "/{brand}")
    @ResponseBody
    public List<Model> modelController(@RequestParam(value = "brand") String brandString){
        System.out.println(" HELLO !!! ");
        List<Model> modelList = null;
        try {
            modelList = universalService.getModelList(brandString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modelList;
    }

}

