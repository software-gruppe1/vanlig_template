package com.example.software_engineer.controller;


import com.example.software_engineer.model.Account;
import com.example.software_engineer.model.Services;
import com.example.software_engineer.repository.JSONRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final JSONRepository jsonRepository = new JSONRepository("src/main/java/com/example/software_engineer/data/account.json", "src/main/java/com/example/software_engineer/data/services.json");



    @GetMapping("/account/{username}")
    public ResponseEntity<Account> getAccount(@PathVariable String username) {
        Account account = jsonRepository.spesificAccount(username);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping("/cart/{username}/{UID}")
    public ResponseEntity<Account> addToShoppingCart(@PathVariable String username, @PathVariable String UID) {
        jsonRepository.addInShoppingcart(username, UID);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/cart/{username}/{UID}")
    public ResponseEntity<Account> removeFromShoppingCart(@PathVariable String username, @PathVariable String UID) {
        jsonRepository.deleteOneServiceFromShoppingcart(username, UID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/cart/{username}")
    public ResponseEntity<Account> clearShoppingCart(@PathVariable String username) {
        jsonRepository.deleteShoppingCart(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/order/{username}")
    public ResponseEntity<?> createOrder(@PathVariable String username) {
        jsonRepository.createOrder(username);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/services/{username}/{UID}")
    public ResponseEntity<Services> deleteService(@PathVariable String username, @PathVariable String UID) {
        jsonRepository.deleteService(username, UID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
