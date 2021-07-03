package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {  // это для работы с папкой static
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/",
            "classpath:/resources/",
            "classpath:/static/",
            "classpath:/public/" };
    @Override
    // здесь указываем как подтягивать папки из static папки - это все что касается темплэйтов
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
//        registry.addResourceHandler("/static/css/**").addResourceLocations("classpath:/static/css/");
//        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
//        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/"); // к папке img обращаться /img/**
//        registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/static/fonts/");
          registry.addResourceHandler("/**").addResourceLocations( CLASSPATH_RESOURCE_LOCATIONS);
    }
}
