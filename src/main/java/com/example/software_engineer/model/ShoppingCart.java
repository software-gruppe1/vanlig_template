package com.example.software_engineer.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private int serviceQuantity;
    private double totalPrice;
    private String username;
    private String email;
    private ArrayList<Services> services;

    public int getServiceQuantity() {return serviceQuantity;}
    public void setServiceQuantity(int antallVarer) {this.serviceQuantity = antallVarer;}

    public double getTotalPrice() {return totalPrice;}
    public void setTotalPrice(double totalPris) {this.totalPrice = totalPris;}

    public String getUsername() {return username;}
    public void setUsername(String brukerNavn) {this.username = brukerNavn;}

    public String getEmail() {return email;}
    public void setEmail(String epostAdresse) {this.email = epostAdresse;}

    public List<Services> getServices() {return services;}
    public void setServices(ArrayList<Services> tjenester) {this.services = tjenester;}
}
