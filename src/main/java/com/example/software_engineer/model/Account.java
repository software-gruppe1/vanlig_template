package com.example.software_engineer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Account {
    private String fullName, password, email;
    private ShoppingCart shopping_cart = new ShoppingCart();
    private String username;
    private ArrayList<Order> orders = new ArrayList<>();  //MAY BE FINAL

    @JsonCreator
    public Account(@JsonProperty("fullName") String fullName,
                   @JsonProperty("password") String password,
                   @JsonProperty("email") String email,
                   @JsonProperty("username") String username) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Order> getOrder() {
        return new ArrayList<>(orders);
    }

    public void add_order(Order order) {
        orders.add(order);
    }

    @Override
    public String toString() {
        return "Account{" +
                "fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", shopping_cart=" + shopping_cart +
                ", username='" + username + '\'' +
                ", orders=" + orders +
                '}';
    }
}
