package com.example.software_engineer.model;

public abstract class Account {
    private String username, fullName, password, email;
    private ShoppingCart shopping_cart;
    private Order order;

    public Account(String userName, String fullName, String password, String email, ShoppingCart shoppingCart, Order order) {
        this.username = userName;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.shopping_cart = shoppingCart;
        this.order = order;

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
