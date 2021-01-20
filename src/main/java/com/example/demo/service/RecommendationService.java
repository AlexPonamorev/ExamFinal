package com.example.demo.service;

import com.example.demo.Recommendation;
import com.example.demo.entity.AutoParts;
import com.example.demo.entity.Brend;
import com.example.demo.entity.Generation;
import com.example.demo.entity.Model;
import org.springframework.stereotype.Service;

@Service
public class RecommendationService {



    public Recommendation recommend(AutoParts autoParts, Brend brend, Model model, Generation generation){


        String url = "https://euroauto.ru/autoservice/akkumulyator/ford/focus/focus_ii_2008-2011/";





        return new Recommendation();
    }

}
