package com.example.software_engineer.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/removeUser/{userId}")
    public String removeUser(@PathVariable Long userId) {
        return userId + " Removed";
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user) {
        return "User Registered";
    }

    @PostMapping("removeUser/[userId]")
    public String deleteAd(@PathVariable Long adId) {
        return adId + " Removed";
    }
}