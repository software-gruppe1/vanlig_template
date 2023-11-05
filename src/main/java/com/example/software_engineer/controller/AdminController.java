package com.example.software_engineer.controller;


import com.example.software_engineer.model.Account;
import com.example.software_engineer.model.Services;
import com.example.software_engineer.repository.JSONRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final JSONRepository jsonRepository;

    public AdminController(JSONRepository jsonRepository) {
        this.jsonRepository = jsonRepository;
    }

    @GetMapping("/services")
    public ResponseEntity<List<Services>> getAllServices() {
        List<Services> services = jsonRepository.allServices();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = jsonRepository.allAccount();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @DeleteMapping("/services/{UID}")
    public ResponseEntity<Void> deleteService(@PathVariable String UID) {
        jsonRepository.deleteService(null, UID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}