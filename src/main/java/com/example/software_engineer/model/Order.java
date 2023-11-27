package com.example.software_engineer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private int orderId;
    private double totalPrice;
    private ArrayList<OrderServiceDetail> services = new ArrayList<>();

    private LocalDate orderDate;
    private static final AtomicInteger count = new AtomicInteger(0);

    @JsonCreator
    public Order(@JsonProperty("totalPrice") double totalPrice,
                 @JsonProperty("orderDate") LocalDate orderDate){
        this.orderId = count.incrementAndGet();
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }


    public int getOrderId() {return orderId;}
    public void setOrderId(int orderId) {this.orderId = orderId;}

    public double getTotalPrice() {return totalPrice;}
    public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}

    public ArrayList<OrderServiceDetail> getServices() {return new ArrayList<>(services) ;}

    public void add_allServices(ArrayList<OrderServiceDetail> service) {
        services.addAll(service);

    }

    public LocalDate getOrderDate() {return orderDate;}
    public void setOrderDate(LocalDate orderDate) {this.orderDate = orderDate;}







}
