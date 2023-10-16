package com.example.software_engineer.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private int orderId;
    private double totalPrice;
    private ArrayList<Services> services;
    private LocalDateTime orderTime;

    public int getOrderId() {return orderId;}
    public void setOrderId(int orderId) {this.orderId = orderId;}

    public double getTotalPrice() {return totalPrice;}
    public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}

    public ArrayList<Services> getServices() {return services;}
    public void setServices(ArrayList<Services> services) {this.services = services;}

    public LocalDateTime getOrderTime() {return orderTime;}
    public void setOrderTime(LocalDateTime orderTime) {this.orderTime = orderTime;}
}
