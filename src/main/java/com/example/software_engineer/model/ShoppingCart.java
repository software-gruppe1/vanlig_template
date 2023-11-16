package com.example.software_engineer.model;

import java.util.ArrayList;



public class ShoppingCart {
    private double totalPrice;

    private ArrayList<String> services = new ArrayList<>(); //MAY BE FINAL


    public ShoppingCart(){
    }

    public ShoppingCart(ArrayList<String> servicesUID){
        this.services = servicesUID;
    }


    public double getTotalPrice() {return totalPrice;}

    public void setTotalPrice(double totalPris) {this.totalPrice = totalPris;}
    public ArrayList<String> getServices() {return new ArrayList<>(services) ;}
    public void add_services(Services service, String serviceID) {
        services.add(serviceID);
        totalPrice += service.getPrice();
    }
    //TODO add_services metoden bør gjøre det sånn at totalsummen blir endret
    //TODO lage en metode for å slette individuelle services i shoppingcarten
    //TODO lage en metode for å for å slette ALLE servcies i shoppingcarten

    public void delete_service(Services service, String serviceID){
        services.remove(serviceID);
        totalPrice-= service.getPrice();

    }
    public void delete_shoppingcart(){
        services.clear();
        totalPrice = 0;


    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "totalPrice=" + totalPrice +
                ", servicesUID=" + services +
                '}';
    }
}
