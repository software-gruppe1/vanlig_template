package com.example.software_engineer.controller;

import com.example.software_engineer.model.Reviews;
import com.example.software_engineer.model.Services;
import com.example.software_engineer.repository.JSONRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {

    private final JSONRepository jsonRepository;

    public AdvertisementController(JSONRepository jsonRepository) {
        this.jsonRepository = jsonRepository;
    }

    @PostMapping("/services")
    public ResponseEntity<Void> createService(@RequestBody Services service) {
        jsonRepository.createService(service.getServiceName(), service.getDescription(),
                service.getDate(), service.getPrice(), service.getAccount(), service.getUID());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/services/{UID}")
    public ResponseEntity<Void> updateService(@PathVariable String UID, @RequestBody Services service) {
        jsonRepository.changeService(service.getServiceName(), service.getDescription(),
                service.getDate(), service.getPrice(), service.getAccount(), UID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/reviews/{UID}")
    public ResponseEntity<Void> addReviewToService(@PathVariable String UID, @RequestBody Reviews review) {
        jsonRepository.addReview(UID, review);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
