package com.example.software_engineer.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Services {
    private String serviceName, description;
    private LocalDateTime dateTime;
    private ArrayList<String> reviews= new ArrayList<>();
    private ArrayList<Integer> rating = new ArrayList<>();

    //konstuktør
    public Services(String serviceName,LocalDateTime dateTime,String description) {
        this.serviceName = serviceName;
        this.dateTime = dateTime;
        this.description = description;

    }


    public Services() {
    }

    //metode for å legge til annmeldelser
    public void placeReview(String review) {
        reviews.add(review);
    }

    //metode for å legge til vurdering
    public void placeRating(int number) {
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException("You can only rate from 1 to 10!");}
        rating.add(number);}

    //gettere og settere
    public ArrayList<String> getReviews() {return reviews;}
    public void setReviews(ArrayList<String> reviews) {this.reviews = reviews;}

    public String getServiceName() {return serviceName;}
    public void setServiceName(String serviceName) {this.serviceName = serviceName;}

    public LocalDateTime getDateTime() {return dateTime;}
    public void setDateTime(LocalDateTime dateTime) {this.dateTime = dateTime;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public ArrayList<Integer> getRating() {return rating;}
    public void setRating(ArrayList<Integer> rating) {this.rating = rating;}

    //TODO  LAGE METODER: OPPRETTE, ENDRE, SLETTE
}

