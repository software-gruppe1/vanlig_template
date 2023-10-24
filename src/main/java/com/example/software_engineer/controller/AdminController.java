package com.example.software_engineer.controller;


import com.example.software_engineer.model.Account;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @DeleteMapping("/removeUser/{userId}")
    public String removeUser(@PathVariable Long userId) {
        return userId + " Removed";
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody Account user) {
        return "User Registered";
    }

    @DeleteMapping("removeUser/{userId}")
    public String deleteAd(@PathVariable Long adId) {
        return adId + " Removed";
    }
}