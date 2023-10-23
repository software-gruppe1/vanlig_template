package com.example.software_engineer.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/profile")
    public String getUserProfile() {
        return "UserProfile";
    }

    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody User user) {
        return user.getUsername() + " Updated!";
    }

}
