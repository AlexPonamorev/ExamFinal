package com.example.demo.service;

import com.example.demo.entity.Brand;
import com.example.demo.entity.Model;
import com.example.demo.repository.BrandRepository;
import com.example.demo.repository.ModelRepository;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.demo.Information.*;

@Service
public class UniversalService {

    @Autowired
    public UniversalService(BrandService brandService, ModelService modelService, ModelRepository modelRepository, BrandRepository brandRepository) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    private final BrandService brandService;
    private final ModelService modelService;
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;


    public List<Brand> getBrandList() throws IOException {
        Elements elements = null;
        String url = BASE_URL;
        elements = Parser.getElements(url, classForParsCar, 0);
        List<Brand> brandList = null;
        for (Element elementX : elements) {
            Brand brand = new Brand();
            brand.setNameValue(elementX.text());
            brand.setNameKey(elementX.attr("value"));

            Brand brandByName = null;
            brandByName = brandRepository.getBrandByNameValue(elementX.text());
            // если такого бренда нет в базе
            if (brandByName == null){
                brandService.add(brand);
            }
        }
        brandList = brandService.getBrandList();
        return brandList;

    }

    public List<Model> getModelList(String brandUrl) throws IOException {
        System.out.println(" I am here ");

        Elements elements = null;
        String url = BASE_URL + brandUrl + DEL;
        elements = Parser.getElements(url, classForParsCar, 1);
        Brand brand = brandRepository.getBrandByNameKey(brandUrl);
        System.out.println(" BrandByModel =  " + brand.getNameKey());

        List<Model> modelList = new ArrayList<>();
        for (Element elementX : elements) {
            Model model = new Model();
            model.setNameValue(elementX.text());
            model.setNameKey(elementX.attr("value"));


            modelList.add(model);
            modelService.add(model,brand);

        }
        modelList.stream().forEach(model -> System.out.println("ModelBefore = " + model.getNameKey()));
        modelList.stream().forEach(model -> System.out.println("ModelAfter = " + model.getNameKey()));

        return modelList;

    }

//    public Map<String, String> getMapGeneration(String brandUrl, String modelUrl) throws IOException {
//        Elements elements = null;
//        String url = BASE_URL + brandUrl + DEL + modelUrl;
//        elements = Parser.getElements(url, classForParsCar, 2);
//        Map<String, String> generationMap = new HashMap<>();
//        for (Element elementX : elements) {
//            generationMap.put(elementX.text(),elementX.attr("value"));
//        }
//        return generationMap;
//    }
//
//    public Map<String,String> getMapAutoParts(String brandUrl, String modelUrl, String generationUrl ) throws IOException {
//        Elements elements = null;
//        String url = BASE_URL + brandUrl + DEL + modelUrl + DEL + generationUrl;
//        elements = Parser.getElements(url, getClassForParsAuParts, 0);
//        Map<String,String> AuPartsMap = new HashMap<>();
//        for (Element elementX : elements) {
//            AuPartsMap.put(elementX.text(),elementX.attr("value"));
//        }
//        return AuPartsMap;
//    }


}
