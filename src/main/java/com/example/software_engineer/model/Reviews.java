package com.example.software_engineer.model;

public class Reviews {
    private String name;
    private String review;
    private int rate;


    public Reviews(String name, String review, int rate) {
        this.name = name;
        this.review = review;
        this.rate = rate;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRate() {
        return rate;
    }

    //metode for å legge til vurdering
    public void setRate(int rate) {
        if (rate < 1 || rate > 10) {
            throw new IllegalArgumentException("You can only rate from 1 to 10!");}
        else {
            this.rate = rate;
        }
    }
}
