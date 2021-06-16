package com.example.demo.service;

import com.example.demo.entity.Brand;
import com.example.demo.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void add(Brand brand){
        brandRepository.save(brand);
    }

    public List<Brand> getBrandList(){
       List<Brand> brandList = brandRepository.getBrandList();
        return brandList;
    }
}
