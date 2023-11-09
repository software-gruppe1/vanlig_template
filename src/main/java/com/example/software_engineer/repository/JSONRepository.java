package com.example.software_engineer.repository;

import com.example.software_engineer.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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
        servicesList.clear();
        accountList.clear();
        Account user = new Account("Ole Nordmann", "User123", "ole_nordmann@gmail.com","User");
        Account admin = new Account("Ali A", "Admin123", "ali_a@gmail.com","Admin");
        accountList.add(user);
        accountList.add(admin);

        Services service1 = new Services("museum of egypt", LocalDate.of(2023, 12, 23), 699, "A beautiful museum stolen by the british", "Admin", "1");
        Services service2 = new Services("city guide in paris", LocalDate.of(2024, 2, 15), 999, "a wonderful guide", "User", "2");
        Services service3 = new Services("bungee jumping in Norway", LocalDate.of(2025, 6, 15), 500, "Jump to your death, it's at least fun", "Admin", "3");

        servicesList.add(service1);
        servicesList.add(service2);
        servicesList.add(service3);

        writeAccountToJSON("src/main/java/com/example/software_engineer/data/account.json", accountList);
        writeServicesToJSON("src/main/java/com/example/software_engineer/data/services.json", servicesList);
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
        this.servicesList = readServicesFromJson("src/main/java/com/example/software_engineer/data/services.json");
        return new ArrayList<>(servicesList);
    }

    public List<Account> allAccount(){
        this.accountList = readAccountFromJson("src/main/java/com/example/software_engineer/data/account.json");
        return new ArrayList<>(accountList);
    }

    public Services spesificService(String UID){
        this.servicesList = readServicesFromJson("src/main/java/com/example/software_engineer/data/services.json");
        for (Services service : servicesList){
            if (service.getUID().equals(UID)){
                return service;
            }
        }
        return null;
    }

    public Account spesificAccount(String user){
        this.accountList = readAccountFromJson("src/main/java/com/example/software_engineer/data/account.json");
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
            servicesList.remove(service);
        } else if (account.equals("Admin")) {
            servicesList.remove(service);
        }
        writeServicesToJSON("src/main/java/com/example/software_engineer/data/account.json", servicesList);
    }

    public void createService(String servicesName, String description, LocalDate date, int price, String account, String UID){
        Services service = new Services(servicesName, date, price, description, account, UID);
        servicesList.add(service);
        writeServicesToJSON("src/main/java/com/example/software_engineer/data/account.json", servicesList);
    }

    public void changeService(String servicesName, String description, LocalDate date, int price, String account, String UID){
        if(account.equals("User") && spesificService(UID).getAccount().equals("User")){
            spesificService(UID).setServiceName(servicesName);
            spesificService(UID).setDescription(description);
            spesificService(UID).setDate(date);
            spesificService(UID).setPrice(price);
        } else if (account.equals("Admin")) {
            spesificService(UID).setServiceName(servicesName);
            spesificService(UID).setDescription(description);
            spesificService(UID).setDate(date);
            spesificService(UID).setPrice(price);
        }
        writeServicesToJSON("src/main/java/com/example/software_engineer/data/account.json", servicesList);
    }

    public void addReview (String UID, Reviews reviews){
        spesificService(UID).placeReview(reviews);
        writeServicesToJSON("src/main/java/com/example/software_engineer/data/account.json", servicesList);
    }

    public void addInShoppingcart(String account, String UID){
        spesificAccount(account).getShopping_cart().add_services(spesificService(UID),UID);
        writeAccountToJSON("src/main/java/com/example/software_engineer/data/account.json", accountList);
    }

    public void deleteShoppingCart (String account){
        spesificAccount(account).getShopping_cart().delete_shoppingcart();
        writeAccountToJSON("src/main/java/com/example/software_engineer/data/account.json", accountList);
    }

    public void deleteOneServiceFromShoppingcart(String account, String UID){
        spesificAccount(account).getShopping_cart().delete_service(spesificService(UID), UID);
        writeAccountToJSON("src/main/java/com/example/software_engineer/data/account.json", accountList);
    }

    public void createOrder(String account){
        Order order = new Order(spesificAccount(account).getShopping_cart().getTotalPrice(), LocalDate.now());
        order.add_allServices(spesificAccount(account).getShopping_cart().getServices());
        spesificAccount(account).add_order(order);
        deleteShoppingCart(account);
        writeAccountToJSON("src/main/java/com/example/software_engineer/data/account.json", accountList);
    }


}
