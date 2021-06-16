package com.example.demo.service;

import com.example.demo.entity.AutoPart;
import com.example.demo.exception.AutoPartsException;
import com.example.demo.repository.AutoPartsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceQuery {

    public ServiceQuery(){}

    AutoPartsRepo autoPartsRepo;
    @Autowired
    public ServiceQuery(AutoPartsRepo autoPartsRepo){this.autoPartsRepo = autoPartsRepo;}

    public AutoPart add(AutoPart autoPart){
        if (autoPartsRepo.existsById(autoPart.getAutoPart_id()) || autoPartsRepo.findByTitle(autoPart.getNameKey().toLowerCase()) != null){
            throw  new AutoPartsException("Деталь есть в базе ");
        }
        return autoPartsRepo.save(autoPart);
    }


}
