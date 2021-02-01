package com.example.demo.service;

import com.example.demo.Recommendation;
import com.example.demo.entity.AutoParts;
import com.example.demo.entity.Brand;
import com.example.demo.entity.Generation;
import com.example.demo.entity.Model;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.example.demo.Information.*;

@Service
public class RecommendationService {

    public Recommendation recommend(AutoParts autoParts, Brand brand, Model model, Generation generation) throws IOException {
        String autoPartsUri = autoParts.getNameKey();
        String brandUri = brand.getNameKey();
        String modelUri = model.getNameKey();
        String generationUri = generation.getNameKey();
        String uri = BASE_URL+autoPartsUri+DEL+brandUri+DEL+modelUri+DEL+generationUri;

        Document document = Jsoup.connect(uri).get();
        Elements tables = document.getElementsByTag("h3");


        String price = tables.get(2).text();
        String clockRate = tables.get(3).text();

        Recommendation recommendation = new Recommendation();

        if(clockRate.equals(NULL_MESSAGE)){
            recommendation.setMessage(MESSAGE_NULL_PRICE);
        }
        else{
            recommendation.setPrice(price);
            recommendation.setClockRate(clockRate);}


        return recommendation;
    }

}
