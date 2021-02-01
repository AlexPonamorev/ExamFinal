package com.example.demo;


import lombok.Getter;
import lombok.Setter;

public class Recommendation {

    @Getter
    @Setter
    private String price;

    @Getter
    @Setter
    private String clockRate;





    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;




}
