package com.example.software_engineer.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private int orderId;
    private double totalPrice;
    private ArrayList<String> servicesUID = new ArrayList<>(); //MAY BE FINAL
    private LocalDate orderDate;
    private static final AtomicInteger count = new AtomicInteger(0);

    public Order(double totalPrice, LocalDate orderDate){
        this.orderId = count.incrementAndGet();
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }


    public int getOrderId() {return orderId;}
    public void setOrderId(int orderId) {this.orderId = orderId;}

    public double getTotalPrice() {return totalPrice;}
    public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}

    public ArrayList<String> getServices() {return new ArrayList<>(servicesUID) ;}
    public void add_services(String serviceID) {
        servicesUID.add(serviceID);

    }

    public LocalDate getOrderDate() {return orderDate;}
    public void setOrderDate(LocalDate orderDate) {this.orderDate = orderDate;}

    //TODO Metode som overfører data fra shoppingcart til ordre og tømmer shoppingcarten.

    public void list_transfer(ShoppingCart shoppingCart){
        //https://www.geeksforgeeks.org/copy-elements-of-one-arraylist-to-another-arraylist-in-java/

        //empty_shoppingcart

    }

}
