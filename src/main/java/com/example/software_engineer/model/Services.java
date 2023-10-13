package com.example.software_engineer.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Services {
    private String serviceName, description;
    private LocalDateTime dateTime;
    private ArrayList<String> reviews= new ArrayList<>();

    //konstuktør
    public Services(String serviceName,LocalDateTime dateTime,String description) {
        this.serviceName = serviceName;
        this.dateTime = dateTime;
        this.description = description;
    }

    //metode for å legge til annmeldelser
    public void leggTilAnmeldelse(String review) {
        reviews.add(review);
    }

    //gettere og settere
    public ArrayList<String> getReviews() {return reviews;}

    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
    }

    public String getServiceName() {return serviceName;}
    public void setServiceName(String serviceName) {this.serviceName = serviceName;}

    public LocalDateTime getDateTime() {return dateTime;}
    public void setDateTime(LocalDateTime dateTime) {this.dateTime = dateTime;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    //TODO Lage en metode for reviews




}

