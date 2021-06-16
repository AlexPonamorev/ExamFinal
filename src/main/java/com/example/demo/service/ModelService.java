package com.example.demo.service;

import com.example.demo.entity.Brand;
import com.example.demo.entity.Model;
import com.example.demo.repository.BrandRepository;
import com.example.demo.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public ModelService(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    public void add(Model model, Brand brand) {
        model.setBrand(brand);
        Model modelN = null;
        modelN = modelRepository.getModelByName(model.getNameValue());


        if (modelN == null)
            modelRepository.save(model);
    }
}
