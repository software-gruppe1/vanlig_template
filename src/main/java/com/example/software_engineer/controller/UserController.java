package com.example.software_engineer.controller;


import com.example.software_engineer.model.Account;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/profile")
    public String getUserProfile() {
        return "UserProfile";
    }

    /*@PostMapping("/updateProfile")
    public void updateProfile(@RequestBody Account user) {
        return Account.getUsername() + " Updated!";
    }*/
}
