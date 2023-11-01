package com.example.software_engineer.controller;


import com.example.software_engineer.model.Account;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @DeleteMapping("/removeUser/{userId}")
    public String removeUser(@PathVariable Long userId) {
        return userId + " Removed";
    }

    @DeleteMapping("deletead/{adId}")
    public String deleteAd(@PathVariable Long adId) {
        return adId + " Removed";
    }
}