package com.example.demo;


import lombok.Getter;
import lombok.Setter;

public class Recommendation {

    private String clockRate;
    public String getPrice() {
        return price;
    }
    public String getClockRate() {
        return clockRate;
    }

    private String price;
    public void setPrice(String price) {
        this.price = price;
    }
    public void setClockRate(String clockRate) {
        this.clockRate = clockRate;
    }

    private String message;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }






}
