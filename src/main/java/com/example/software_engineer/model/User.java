package com.example.software_engineer.model;

public class User extends Account{


    public User (String fullName, String password, String email,
                 ShoppingCart shopping_cart){
        super( fullName, password, email, shopping_cart);

    }

    public String getUsername() {
        return "User";
    }
}
