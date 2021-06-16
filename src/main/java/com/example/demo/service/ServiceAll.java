package com.example.demo.service;

import com.example.demo.entity.AutoPart;
import com.example.demo.entity.Brand;
import com.example.demo.entity.Generation;
import com.example.demo.entity.Model;
import org.springframework.stereotype.Service;


@Service
public class ServiceAll {

    public AutoPart parseAutoParts(String autoParts){
        AutoPart autoPartNew = new AutoPart();
        autoPartNew.setNameKey(autoParts);
        return autoPartNew;
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
