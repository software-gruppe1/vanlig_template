package com.example.software_engineer.controller;

import com.example.software_engineer.model.Reviews;
import com.example.software_engineer.model.Services;
import com.example.software_engineer.repository.JSONRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {

    private final JSONRepository jsonRepository = new JSONRepository("src/main/java/com/example/software_engineer/data/account.json", "src/main/java/com/example/software_engineer/data/services.json");

    @GetMapping("/services/all")
    public ResponseEntity<List<Services>> getAllAdvertisement() {
        List<Services> advertisements = jsonRepository.allServices();
        return ResponseEntity.ok(advertisements);
    }

    @PostMapping("/services")
    public ResponseEntity<Services> createService(@RequestBody Services service) {
        jsonRepository.createService(service.getServiceName(), service.getDescription(), service.getLocation(), service.getDate(), service.getPrice(), service.getAccount(), service.getUID());
        return new ResponseEntity<>(service, HttpStatus.CREATED);
    }

    @PutMapping("/services/{UID}")
    public ResponseEntity<Services> updateService(@PathVariable String UID, @RequestBody Services service) {
        jsonRepository.changeService(service.getServiceName(), service.getDescription(), service.getLocation(),
                service.getDate(), service.getPrice(), service.getAccount(), UID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/reviews/{UID}")
    public ResponseEntity<Services> addReviewToService(@PathVariable String UID, @RequestBody Reviews review) {
        jsonRepository.addReview(UID, review);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{UID}")
    public ResponseEntity<Services> getSpecificService(@PathVariable String UID) {
        Services service = jsonRepository.spesificService(UID,1);
        if (service != null) {
            return new ResponseEntity<>(service, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
