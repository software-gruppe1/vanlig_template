package com.example.software_engineer.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private int orderId;
    private double totalPrice;
    private ArrayList<Services> services;
    private LocalDateTime orderTime;

    public Order(int orderId, double totalPrice, LocalDateTime orderTime){
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.orderTime = orderTime;

    }

    public Order(){
    }

    public int getOrderId() {return orderId;}
    public void setOrderId(int orderId) {this.orderId = orderId;}

    public double getTotalPrice() {return totalPrice;}
    public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}

    public ArrayList<Services> getServices() {return new ArrayList<Services>(services) ;}
    public void add_services(Services service) {
        services.add(service);}

    public LocalDateTime getOrderTime() {return orderTime;}
    public void setOrderTime(LocalDateTime orderTime) {this.orderTime = orderTime;}

    //TODO Metode som overfører data fra shoppingcart til ordre og tømmer shoppingcarten.
}
