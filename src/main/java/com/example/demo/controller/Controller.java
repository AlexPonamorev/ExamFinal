package com.example.demo.controller;

import com.example.demo.Recommendation;
import com.example.demo.entity.AutoParts;
import com.example.demo.entity.Brend;
import com.example.demo.entity.Generation;
import com.example.demo.entity.Model;
import com.example.demo.service.ModelService;
import com.example.demo.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PatchMapping(value = "/monitor/dev/monitorings/{group}/{id}/forget")
 * public void forgetMonitoring(
 * @PathVariable(name = "id") String id,
 * @PathVariable(name = "group") String group,
 * @RequestParam(name = "pack", required = false) String zooNode
 * ) {
 **/

@RestController
public class Controller {

    @Autowired
    RecommendationService recommendationService;

    @Autowired
    ModelService modelService;

    @GetMapping(value = "/autoservice/{auto_parts}/{brend}/{model}/{generation}")
    public Recommendation getRecommendation(
            @PathVariable(name = "auto_parts") String autoPartsString,
            @PathVariable(name = "brend") String brendString,
            @PathVariable(name = "model") String modelString,
            @PathVariable(name = "generation") String generationString) {

        AutoParts autoParts = modelService.parseAutoparts(autoPartsString);
        Brend brend = modelService.parseBrend(brendString);
        Model model = modelService.parseModel(modelString);
        Generation generation = modelService.parseGeneration(generationString);

        Recommendation recommend = recommendationService.recommend(autoParts, brend, model, generation);


        return recommend;
    }
}
