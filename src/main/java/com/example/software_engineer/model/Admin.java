package com.example.software_engineer.model;

public class Admin extends Account{


    public Admin(String username,String fullName,  String password, String email, ShoppingCart shopping_cart,
                 Order order) {
        super(username, fullName, password, email, shopping_cart, order);
    }

    //TODO ADMIN BØR HA ACCESS TIL Å SLETTE ANNONSER OG ANDRE ADMIN EVNER

}
