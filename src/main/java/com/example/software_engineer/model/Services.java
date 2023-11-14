package com.example.software_engineer.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Services {
    private String serviceName, description, location;
    private LocalDate date;
    private int price;
    private ArrayList<Reviews> all_reviews = new ArrayList<>();
    private String account;
    private String UID;

    //konstuktør
    public Services(String serviceName,LocalDate date, int price, String description, String location, String account, String UID) {
        this.serviceName = serviceName;
        this.date = date;
        this.price = price;
        this.description = description;
        this.location = location;
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

    public LocalDate getDate() {return date;}
    public void setDate(LocalDate date) {this.date = date;}

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Services{" +
                "serviceName='" + serviceName + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", all_reviews=" + all_reviews +
                ", account='" + account + '\'' +
                ", UID='" + UID + '\'' +
                '}';
    }
    //TODO  LAGE METODER: OPPRETTE, ENDRE, SLETTE
}

