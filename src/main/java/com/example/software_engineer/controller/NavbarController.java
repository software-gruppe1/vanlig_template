package com.example.software_engineer.controller;


import org.springframework.web.bind.annotation.RestController;


@RestController

public class NavbarController {
    public String getNavbar() {
        return "Navbar";
    }
}
