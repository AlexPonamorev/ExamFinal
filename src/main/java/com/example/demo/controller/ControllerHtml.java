package com.example.demo.controller;

import com.example.demo.Recommendation;
import com.example.demo.entity.*;
import com.example.demo.service.RecommendationService;
import com.example.demo.service.ServiceAll;
import com.example.demo.service.UniversalService;
import com.example.demo.service.UniversalServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@RequestMapping("/suggestHtml")
@Controller
public class ControllerHtml {


    private String temporaryBrand;
    private String temporaryModel;
    private String temporaryGen;
    private final RecommendationService recommendationService;
    private final ServiceAll serviceAll;
    private final UniversalServiceOld universalServiceOld;

    @Autowired
    public ControllerHtml(RecommendationService recommendationService, ServiceAll serviceAll, UniversalServiceOld universalServiceOld) {
        this.recommendationService = recommendationService;
        this.serviceAll = serviceAll;
        this.universalServiceOld = universalServiceOld;
    }

    @GetMapping
    public String brandController(org.springframework.ui.Model model){
        Map<String,String> BM = new HashMap<>();

        try {
            BM  = universalServiceOld.getMapBrand();
            model.addAttribute("brandMap", BM);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "brand";
    }

    @GetMapping(value = "/{brand}")
    public String modelController(@RequestParam(value = "braaand") String brandString,
                                  org.springframework.ui.Model model){
        Map<String,String> MM = new HashMap<>();
        try {
            MM = universalServiceOld.getMapModel(brandString);
            model.addAttribute("modelMap", MM);
            model.addAttribute("brandT", temporaryBrand=brandString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "model";
    }
    // извлекает URI
//    @PathVariable(name = "brand") String brandsString,
//    @PathVariable(name = "model") String modelString,
    @GetMapping(value = "/{brand}/{model}" )
    public String generationController(
            @PathVariable(name = "brand") String brandsString,
            @RequestParam(value = "model") String modelString,
    org.springframework.ui.Model model){
        Map<String,String> GM = new HashMap<>();
        try {
            GM = universalServiceOld.getMapGeneration(brandsString,modelString);
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
            @RequestParam(value = "generation") String generationString,
            org.springframework.ui.Model model
    ){
        Map<String, String> APM = new HashMap<>();
        try {
            APM = universalServiceOld.getMapAutoParts(brandsString,modelString,generationString);
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
            @RequestParam(value = "auto_parts") String autoPartsString,
            @PathVariable(value = "brand") String brandString,
            @PathVariable(value = "model") String modelString,
            @PathVariable(value = "generation") String generationString,
            org.springframework.ui.Model modelT) {

        AutoPart autoParts = serviceAll.parseAutoParts(autoPartsString);
        Brand brand = serviceAll.parseBrand(brandString);
        Model model = serviceAll.parseModel(modelString);
        Generation generation = serviceAll.parseGeneration(generationString);

        Recommendation recommend = null;
        try {
            recommend = recommendationService.recommend(autoParts, brand, model, generation);

        } catch (IOException e) {
            e.printStackTrace();
        }
        modelT.addAttribute("recommendMy",recommend);
        return "recommend";
    }

    @ModelAttribute("headerMessage")
    public String greetings(){
        return " --- Цены на работы --- ";
    }

//    @GetMapping()
//    public String redirect(@ModelAttribute("recommend")RecommendationService recommendN ){
//        return "redirect:/suggestHtml";
//    }

}
