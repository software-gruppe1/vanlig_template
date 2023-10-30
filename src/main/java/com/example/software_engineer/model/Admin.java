package com.example.software_engineer.model;

public class Admin extends Account{

    public Admin(String fullName,  String password, String email, ShoppingCart shopping_cart) {

        super(fullName, password, email, shopping_cart);
    }

    public String getUsername() {
        return "Admin";
    }
    //TODO ADMIN BØR HA ACCESS TIL Å SLETTE ANNONSER OG ANDRE ADMIN EVNER

}
