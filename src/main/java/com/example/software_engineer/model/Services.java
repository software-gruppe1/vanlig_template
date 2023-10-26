package com.example.software_engineer.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Services {
    private String serviceName, description;
    private LocalDateTime dateTime;
    private ArrayList<Reviews> all_reviews = new ArrayList<>();
    private String account;

    private String UID;

    //konstuktør
    public Services(String serviceName,LocalDateTime dateTime,String description, String account, String UID) {
        this.serviceName = serviceName;
        this.dateTime = dateTime;
        this.description = description;
        this.account = account;
        this.UID = UID;

    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public Services() {
    }

    //metode for å legge til annmeldelser
    public void placeReview(Reviews review) {
        all_reviews.add(review);
    }

    //gettere og settere
    public ArrayList<Reviews> getAll_reviews() {
        return new ArrayList<>(all_reviews);
    }

    public String getServiceName() {return serviceName;}
    public void setServiceName(String serviceName) {this.serviceName = serviceName;}

    public LocalDateTime getDateTime() {return dateTime;}
    public void setDateTime(LocalDateTime dateTime) {this.dateTime = dateTime;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    //TODO  LAGE METODER: OPPRETTE, ENDRE, SLETTE
}

