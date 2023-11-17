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

    @PostMapping("/cart/{UID}")
    public ResponseEntity<Account> addToShoppingCart(@RequestBody String account, @PathVariable String UID) {
        jsonRepository.addInShoppingcart(account, UID);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/cart/{UID}")
    public ResponseEntity<Account> removeFromShoppingCart(@RequestBody String account, @PathVariable String UID) {
        jsonRepository.deleteOneServiceFromShoppingcart(account, UID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/cart")
    public ResponseEntity<Account> clearShoppingCart(@RequestBody String account) {
        jsonRepository.deleteShoppingCart(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<?> createOrder(@RequestBody String accountUsername) {
        jsonRepository.createOrder(accountUsername);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/services/{UID}")
    public ResponseEntity<Services> deleteService(@PathVariable String UID) {
        jsonRepository.deleteService("User", UID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
