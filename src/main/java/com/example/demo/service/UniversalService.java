package com.example.demo.service;

import com.example.demo.entity.AutoPart;
import com.example.demo.entity.Brand;
import com.example.demo.entity.Generation;
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

    public List<Model> getModelList(String brandURI) throws IOException {
        System.out.println(" I am here ");

        Elements elements = null;
        String url = BASE_URL + brandURI + DEL;
        elements = Parser.getElements(url, classForParsCar, 1);
        Brand brand = brandRepository.getBrandByNameKey(brandURI);
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

    public List<Generation> getGenerationList(String brandURI, String modelURI) throws IOException {
        Elements elements = null;
        String url = BASE_URL + brandURI + DEL + modelURI;
        elements = Parser.getElements(url, classForParsCar, 2);
        List<Generation> generationList = new ArrayList<>();
        for (Element elementX : elements) {
          Generation generation = new Generation();

            generation.setNameValue(elementX.text());
            generation.setNameKey(elementX.attr("value"));


            generationList.add(generation);
//            generationService.add(model,brand);
        }
        return generationList;
    }

    public List<AutoPart> getAutoPartsList(String brandURI, String modelURI, String generationURI ) throws IOException {
        Elements elements = null;
        String url = BASE_URL + brandURI + DEL + modelURI + DEL + generationURI;
        elements = Parser.getElements(url, getClassForParsAuParts, 0);
        List<AutoPart> autoPartList = new ArrayList<>();
        for (Element elementX : elements) {
            AutoPart autoPart = new AutoPart();
            autoPart.setNameValue(elementX.text());
            autoPart.setNameKey(elementX.attr("value"));
            autoPartList.add(autoPart);
        }

        return autoPartList;
    }


}
