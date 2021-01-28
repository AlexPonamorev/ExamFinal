package com.example.demo.service;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.example.demo.Information.*;

@Service
public class UniversalService {

    @Autowired
    Parser parser; // какая видимасть должна быть?

    public Map<String, String> getMapBrand() throws IOException {
        Elements elements = null;
        String url = BASE_URL;
        elements = parser.getElements(url, classForParsCar, 0);
        Map<String, String> mapBrand = new HashMap<>();
        for (Element elementX : elements) {
            mapBrand.put(elementX.attr("value"),elementX.text());
        }
        return mapBrand;

    }

    public Map<String, String> getMapModel(String brandUrl) throws IOException {

        Elements elements = null;
        String url = BASE_URL + brandUrl + DEL;
        elements = parser.getElements(url, classForParsCar, 1);
        Map<String, String> mapModel = new HashMap<>();
        for (Element elementX : elements) {
            mapModel.put(elementX.attr("value"),elementX.text());
        }
        return mapModel;

    }

    public Map<String, String> getMapGeneration(String brandUrl, String modelUrl) throws IOException {
        Elements elements = null;
        String url = BASE_URL + brandUrl + DEL + modelUrl;
        elements = parser.getElements(url, classForParsCar, 2);
        Map<String, String> generationMap = new HashMap<>();
        for (Element elementX : elements) {
            generationMap.put(elementX.attr("value"),elementX.text());
        }
        return generationMap;
    }

    public Map<String,String> getMapAutoParts(String brandUrl, String modelUrl, String generationUrl ) throws IOException {
        Elements elements = null;
        String url = BASE_URL + brandUrl + DEL + modelUrl + DEL + generationUrl;
        elements = parser.getElements(url, getClassForParsAuParts, 0);
        Map<String,String> AuPartsMap = new HashMap<>();
        for (Element elementX : elements) {
            AuPartsMap.put(elementX.attr("value"),elementX.text());
        }
        return AuPartsMap;
    }


}
