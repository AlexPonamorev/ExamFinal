package com.example.demo.service;

import com.example.demo.entity.AutoParts;
import com.example.demo.entity.Brend;
import com.example.demo.entity.Generation;
import com.example.demo.entity.Model;
import org.springframework.stereotype.Service;

@Service
public class ModelService {


    public AutoParts parseAutoparts(String autoParts){
        return new AutoParts();
    }

    public Brend parseBrend(String Brend){
        return new Brend();
    }

    public Model parseModel(String Model){
        return new Model();
    }

    public Generation parseGeneration(String Model){
        return new Generation();
    }

}
