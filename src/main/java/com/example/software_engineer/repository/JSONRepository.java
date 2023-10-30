package com.example.software_engineer.repository;

import com.example.software_engineer.model.Account;
import com.example.software_engineer.model.Services;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JSONRepository {
    private List<Account> accountList;
    private List<Services> servicesList;

    public JSONRepository(){

    }

    public List<Object> lesFraJson(String filepath){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.registerModule(new JavaTimeModule());
            Object[] characterArray = objectMapper.readValue(new File(filepath), Object[].class);

            return Arrays.asList(characterArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void skrivTilJSON(String jsonfil, List<Object> liste){
        Thread jsonskriv = new Thread(() ->{
            ObjectMapper objectMapper = new ObjectMapper();

            File file = new File(jsonfil);

            try{
                objectMapper.registerModule(new JavaTimeModule());
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, liste);
            } catch (IOException e){
                e.printStackTrace();
            }
        });
    }

}
