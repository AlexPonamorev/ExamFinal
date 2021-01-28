package com.example.demo.controller;

import com.example.demo.Recommendation;
import com.example.demo.entity.AutoParts;
import com.example.demo.entity.Brand;
import com.example.demo.entity.Generation;
import com.example.demo.entity.Model;
import com.example.demo.service.ServiceAll;
import com.example.demo.service.RecommendationService;
import com.example.demo.service.UniversalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/***/
@RequestMapping("/suggest")
@RestController
public class Controller {

    @Autowired
    RecommendationService recommendationService;
    @Autowired
    ServiceAll serviceAll;
    @Autowired
    UniversalService universalService;

    @GetMapping(value = "/{brand}/{model}/{generation}/{auto_parts}")
    public Recommendation getRecommendation(
            @PathVariable(name = "auto_parts") String autoPartsString,
            @PathVariable(name = "brand") String brandString,
            @PathVariable(name = "model") String modelString,
            @PathVariable(name = "generation") String generationString) {

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
        return recommend;
    }
    @GetMapping(value = "/")
    public Map<String,String> brandController(){
       Map<String,String> BM = new HashMap<>();

        try {
            BM = universalService.getMapBrand();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BM;
    }

    @GetMapping(value = "/{brand}")
    public Map<String,String> modelController(@PathVariable(name= "brand") String brandString){
        Map<String,String> MM = new HashMap<>();

        try {
            MM = universalService.getMapModel(brandString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MM;
    }

    @GetMapping(value = "/{brand}/{model}" )
    public Map<String,String> generationController(
            @PathVariable(name = "brand") String brandsString,@PathVariable(name = "model") String modelString ){
        Map<String,String> GM = new HashMap<>();
        try {
            GM = universalService.getMapGeneration(brandsString,modelString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return GM;
    }

    @GetMapping(value = "/{brand}/{model}/{generation}")
    public Map<String,String> autoPartsController(
            @PathVariable(name = "brand") String brandString,@PathVariable(name = "model") String modelString,
            @PathVariable(name ="generation") String generationString
    ){
        Map<String, String> APM = new HashMap<>();
        try {
            APM = universalService.getMapAutoParts(brandString,modelString,generationString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return APM;
    }



}
