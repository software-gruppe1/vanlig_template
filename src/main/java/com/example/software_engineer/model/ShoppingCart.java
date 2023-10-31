package com.example.software_engineer.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private double totalPrice;
    private ArrayList<Services> services = new ArrayList<>();

    public ShoppingCart(){
    }


    public double getTotalPrice() {return totalPrice;}
    public void setTotalPrice(double totalPris) {this.totalPrice = totalPris;}

    public ArrayList<Services> getServices() {return new ArrayList<>(services) ;}
    public void add_services(Services service) {
        services.add(service);}
    //TODO add_services metoden bør gjøre det sånn at totalsummen blir endret
    //TODO lage en metode for å slette individuelle services i shoppingcarten
    //TODO lage en metode for å for å slette ALLE servcies i shoppingcarten
}
