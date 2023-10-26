package com.example.software_engineer.model;

public class User extends Account{


    public User (String user_name, String fullName, String password, String email,
                 ShoppingCart shopping_cart, Order order){
        super(user_name, fullName, password, email, shopping_cart, order);

    }


}
