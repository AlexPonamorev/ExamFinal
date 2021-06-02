package com.example.demo;


import lombok.Getter;
import lombok.Setter;

public class Recommendation {


    public String getPrice() {
        return price;
    }

    public String getClockRate() {
        return clockRate;
    }

    private String price;
    private String clockRate;

    public void setPrice(String price) {
        this.price = price;
    }

    public void setClockRate(String clockRate) {
        this.clockRate = clockRate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;




}
