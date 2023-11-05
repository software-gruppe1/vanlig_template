package com.example.software_engineer.model;

public class User extends Account{


    public User (String fullName, String password, String email,
                 ShoppingCart shopping_cart, String username){
        super( fullName, password, email, shopping_cart, username);

    }


}
