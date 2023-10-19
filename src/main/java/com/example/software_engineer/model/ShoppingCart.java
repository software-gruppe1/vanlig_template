package com.example.software_engineer.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private int serviceQuantity;
    private double totalPrice;
    private ArrayList<Services> services;

    public ShoppingCart(int serviceQuantity, double totalPrice){
        this.serviceQuantity = serviceQuantity;
        this.totalPrice = totalPrice;

    }

    public int getServiceQuantity() {return serviceQuantity;}
    public void setServiceQuantity(int amount_services) {this.serviceQuantity = amount_services;}

    public double getTotalPrice() {return totalPrice;}
    public void setTotalPrice(double totalPris) {this.totalPrice = totalPris;}

    public List<Services> getServices() {return services;}
    public void setServices(ArrayList<Services> tjenester) {this.services = tjenester;}
}
