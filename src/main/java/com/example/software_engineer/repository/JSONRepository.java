package com.example.software_engineer.repository;

import com.example.software_engineer.model.Account;
import com.example.software_engineer.model.Reviews;
import com.example.software_engineer.model.Services;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JSONRepository {
    private List<Account> accountList = new ArrayList<>();
    private List<Services> servicesList = new ArrayList<>();

    public JSONRepository(){
        List<Account> accountList = readAccountFromJson("src/main/java/com/example/software_engineer/data/account.json");
        List<Services> servicesList = readServicesFromJson("src/main/java/com/example/software_engineer/data/services.json");
    }

    public List<Account> readAccountFromJson(String filepath){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.registerModule(new JavaTimeModule());
            Account[] characterArray = objectMapper.readValue(new File(filepath), Account[].class);

            return Arrays.asList(characterArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Services> readServicesFromJson(String filepath){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.registerModule(new JavaTimeModule());
            Services[] characterArray = objectMapper.readValue(new File(filepath), Services[].class);

            return Arrays.asList(characterArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void writeAccountToJSON(String jsonfil, List<Account> liste){
            ObjectMapper objectMapper = new ObjectMapper();

            File file = new File(jsonfil);

            try{
                objectMapper.registerModule(new JavaTimeModule());
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, liste);
            } catch (IOException e){
                e.printStackTrace();
            }
    }

    public void writeServicesToJSON(String jsonfil, List<Services> liste){
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File(jsonfil);

        try{
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, liste);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Services> allServices(){

        return new ArrayList<>(servicesList);
    }

    public List<Account> allAccount(){
        return new ArrayList<>(accountList);
    }

    public Services spesificService(String UID){
        for (Services service : servicesList){
            if (service.getUID().equals(UID)){
                return service;
            }
        }
        return null;
    }

    public Account spesificAccount(String user){
        for (Account account : accountList){
            if (account.getUsername().equals(user)){
                return account;
            }
        }
        return null;
    }

    public void deleteService(String account, String UID){
        Services service = spesificService(UID);
        if(account.equals("User") && service.getAccount().equals("User")){
            accountList.remove(service);
        } else if (account.equals("Admin")) {
            accountList.remove(service);
        }
        writeServicesToJSON("src/main/java/com/example/software_engineer/data/account.json", servicesList);
    }

    public void createService(String servicesName, String description, LocalDate date, int price, String account, String UID){
        Services service = new Services(servicesName, date, price, description, account, UID);
        servicesList.add(service);
        writeServicesToJSON("src/main/java/com/example/software_engineer/data/account.json", servicesList);
    }

    public void changeService(String servicesName, String description, LocalDate date, int price, String account, String UID){
    }

    public void addReview (String UID, Reviews reviews){
    }

    public void addInShoppingcart(String account, String UID){
    }

    public void deleteShoppingCart (String account){
    }

    public void deleteOneServiceFromShoppingcart(String account, String UID){
    }

    public void createOrder(String account){
    }


}
