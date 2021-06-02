package com.example.demo.service;

import com.example.demo.entity.AutoParts;
import com.example.demo.entity.Brand;
import com.example.demo.entity.Generation;
import com.example.demo.entity.Model;
import org.springframework.stereotype.Service;


@Service
public class ServiceAll {

    public AutoParts parseAutoParts(String autoParts){
        AutoParts autoPartsNew = new AutoParts();
        autoPartsNew.setNameKey(autoParts);
        return autoPartsNew;
    }

    public Brand parseBrand(String brand){
        Brand brandNew = new Brand();
        brandNew.setNameKey(brand);
        return brandNew;
    }

    public Model parseModel(String model){
        Model modelNew = new Model();
        modelNew.setNameKey(model);
        return modelNew;
    }

    public Generation parseGeneration(String generation){
        Generation generationNew = new Generation();
        generationNew.setNameKey(generation);
        return generationNew;
    }
}
