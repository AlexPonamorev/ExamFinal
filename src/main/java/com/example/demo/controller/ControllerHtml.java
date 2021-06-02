package com.example.demo.controller;

import com.example.demo.Recommendation;
import com.example.demo.entity.*;
import com.example.demo.service.RecommendationService;
import com.example.demo.service.ServiceAll;
import com.example.demo.service.UniversalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@RequestMapping("/suggestHtml")
@Controller
public class ControllerHtml {

    private String temporaryBrand;
    private String temporaryModel;
    private String temporaryGen;
    @Autowired
    RecommendationService recommendationService;
    @Autowired
    ServiceAll serviceAll;
    @Autowired
    UniversalService universalService;

    @GetMapping(value = "/")
    public String brandController(org.springframework.ui.Model model){
        Map<String,String> BM = new HashMap<>();

        try {
            BM = universalService.getMapBrand();
            model.addAttribute("brandMap", BM);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "brand";
    }

    @GetMapping(value = "/{brand}")
    public String modelController(@PathVariable(name= "brand") String brandString,
                                  org.springframework.ui.Model model){
        Map<String,String> MM = new HashMap<>();
        try {
            MM = universalService.getMapModel(brandString);
            model.addAttribute("modelMap", MM);
            model.addAttribute("brandTemp", temporaryBrand=brandString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "model";
    }

    @GetMapping(value = "/{brand}/{model}" )
    public String generationController(
            @PathVariable(name = "brand") String brandsString,
            @PathVariable(name = "model") String modelString,
    org.springframework.ui.Model model){
        Map<String,String> GM = new HashMap<>();
        try {
            GM = universalService.getMapGeneration(brandsString,modelString);
            model.addAttribute("generationMap", GM);
            model.addAttribute("brandT",temporaryBrand=brandsString);
            model.addAttribute("modelT",temporaryModel=modelString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "generation";
    }

    @GetMapping(value = "/{brand}/{model}/{generation}")
    public String autoPartsController(
            @PathVariable(name = "brand") String brandsString,
            @PathVariable(name = "model") String modelString,
            @PathVariable(name ="generation") String generationString,
            org.springframework.ui.Model model
    ){
        Map<String, String> APM = new HashMap<>();
        try {
            APM = universalService.getMapAutoParts(brandsString,modelString,generationString);
            model.addAttribute("mapAuto", APM);
            model.addAttribute("brandT",temporaryBrand=brandsString);
            model.addAttribute("modelT",temporaryModel=modelString);
            model.addAttribute("genT", temporaryGen=generationString);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "mapAuto";
    }

    @GetMapping(value = "/{brand}/{model}/{generation}/{auto_parts}")
    public String getRecommendation(
            @PathVariable(name = "auto_parts") String autoPartsString,
            @PathVariable(name = "brand") String brandString,
            @PathVariable(name = "model") String modelString,
            @PathVariable(name = "generation") String generationString,
            org.springframework.ui.Model modelT) {

        AutoParts autoParts = serviceAll.parseAutoParts(autoPartsString);
        Brand brand = serviceAll.parseBrand(brandString);
        Model model = serviceAll.parseModel(modelString);
        Generation generation = serviceAll.parseGeneration(generationString);

        Recommendation recommend = null;
        try {
            recommend = recommendationService.recommend(autoParts, brand, model, generation);

        } catch (IOException e) {
            e.printStackTrace();
        }
        modelT.addAttribute("recommendMy", recommend);
        return "recommend";
    }

}
