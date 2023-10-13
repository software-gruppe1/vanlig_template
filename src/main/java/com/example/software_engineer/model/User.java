package com.example.software_engineer.model;

public class User implements Account{
    private String user_name, first_name, last_name;
    private ShoppingCart shopping_cart;
    private Order order;

    public String getUser_name() {return user_name;}
    public void setUser_name(String user_name) {this.user_name = user_name;}

    public String getFirst_name() {return first_name;}
    public void setFirst_name(String first_name) {this.first_name = first_name;}

    public String getLast_name() {return last_name;}
    public void setLast_name(String last_name) {this.last_name = last_name;}

    public ShoppingCart getShopping_cart() {return shopping_cart;}
    public void setShopping_cart(ShoppingCart shopping_cart) {this.shopping_cart = shopping_cart;}

    public Order getOrder() {return order;}
    public void setOrder(Order order) {this.order = order;}
}
