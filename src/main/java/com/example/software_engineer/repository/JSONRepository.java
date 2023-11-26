package com.example.software_engineer.repository;

import com.example.software_engineer.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class  JSONRepository {
    private List<Account> accountList = new ArrayList<>();
    private List<Services> servicesList = new ArrayList<>();
    private String servicePath;
    private String accountPath;

    @Autowired
    public JSONRepository(String accountPath, String servicePath){
        this.accountPath = accountPath;
        this.servicePath = servicePath;
    }

    public JSONRepository(String accountPath, String servicePath, List<Account> accountList, List<Services> servicesList){
        this.accountPath = accountPath;
        this.servicePath = servicePath;
        writeAccountToJSON(accountPath, accountList);
        writeServicesToJSON(servicePath, servicesList);
    }

    public List<Account> readAccountFromJson(String filepath){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.registerModule(new JavaTimeModule());
            Account[] characterArray = objectMapper.readValue(new File(filepath), Account[].class);
            ArrayList<Account> account = new ArrayList<>(Arrays.asList(characterArray));
            //System.out.println(account);
            return account;
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

            return new ArrayList<Services>(Arrays.asList(characterArray));
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
        this.servicesList = readServicesFromJson(servicePath);
        return new ArrayList<>(servicesList);
    }

    public List<Account> allAccount(){
        this.accountList = readAccountFromJson(accountPath);
        return new ArrayList<>(accountList);
    }

    public Services spesificService(String UID){
        this.servicesList = readServicesFromJson(servicePath);
        for (Services service : servicesList){
            if (service.getUID().equals(UID)){
                return service;
            }
        }
        return null;
    }

    public Account spesificAccount(String user){
        this.accountList = readAccountFromJson(accountPath);
        for (Account account : accountList){
            if (account.getUsername().equals(user)){
                return account;
            }
        }
        return null;
    }

    public void deleteService(String account, String UID){
        Services service = spesificService(UID);
        if(service.getAccount().equals("User") && account.equals("User")){
            servicesList.remove(service);
        } else if (account.equals("Admin")) {
            servicesList.remove(service);
        }
        writeServicesToJSON(servicePath, servicesList);
    }

    public void createService(String servicesName, String description, String location, LocalDate date, int price, String account, String UID){
        Services service = new Services(servicesName, date, price, description, location, account, UID);
        servicesList.add(service);
        writeServicesToJSON(servicePath, servicesList);
    }

    public void changeService(String servicesName, String description, String location, LocalDate date, int price, String account, String UID){
        Services service = spesificService(UID);
        if(account.equals("User") && spesificService(UID).getAccount().equals("User")){
            service.setServiceName(servicesName);
            service.setDescription(description);
            service.setLocation(location);
            service.setDate(date);
            service.setPrice(price);
        } else if (account.equals("Admin")) {
            service.setServiceName(servicesName);
            service.setDescription(description);
            service.setLocation(location);
            service.setDate(date);
            service.setPrice(price);
        }
        writeServicesToJSON(servicePath, servicesList);
        System.out.println("Changed to: "+spesificService(UID));
    }

    public void addReview (String UID, Reviews reviews){
        spesificService(UID).placeReview(reviews);
        writeServicesToJSON(servicePath, servicesList);
    }

    public void addInShoppingcart(String account, String UID){
        Account account1 = spesificAccount(account);
        account1.getShopping_cart().add_services(spesificService(UID),UID);
        writeAccountToJSON(accountPath, accountList);
        //System.out.println(spesificAccount("User"));
    }

    public void deleteShoppingCart (String account){
        spesificAccount(account).getShopping_cart().delete_shoppingcart();
        writeAccountToJSON(accountPath, accountList);
    }

    public void deleteOneServiceFromShoppingcart(String account, String UID){
        spesificAccount(account).getShopping_cart().delete_service(spesificService(UID), UID);
        writeAccountToJSON(accountPath, accountList);
    }

    public void createOrder(String account){
        Order order = new Order(spesificAccount(account).getShopping_cart().getTotalPrice(), LocalDate.now());
        ArrayList<OrderServiceDetail> serviceDetails = new ArrayList<>();
        for(String service : spesificAccount(account).getShopping_cart().getServices()){
            serviceDetails.add(new OrderServiceDetail(spesificService(service).getServiceName(), spesificService(service).getPrice()));
        }
        order.add_allServices(serviceDetails);
        spesificAccount(account).add_order(order);
        writeAccountToJSON(accountPath, accountList);
        deleteShoppingCart(account);
        writeAccountToJSON(accountPath, accountList);
        System.out.println(spesificAccount("Admin"));
    }

}
