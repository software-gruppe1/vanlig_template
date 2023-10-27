package com.example.software_engineer.model;

import java.util.ArrayList;

public abstract class Account {
    private String username, fullName, password, email;
    private ShoppingCart shopping_cart;
    private ArrayList<Order> orders;

    public Account(String userName, String fullName, String password, String email, ShoppingCart shoppingCart) {
        this.username = userName;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.shopping_cart = shoppingCart;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ShoppingCart getShopping_cart() {
        return shopping_cart;
    }

    public void setShopping_cart(ShoppingCart shopping_cart) {
        this.shopping_cart = shopping_cart;
    }

    public ArrayList<Order> getOrder() {
        return new ArrayList<Order>(orders);
    }

    public void add_order(Order order) {
        orders.add(order);
    }
    //TODO lage en metode som legger til ordre FINITO
}
