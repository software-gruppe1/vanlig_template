package com.example.software_engineer.repository;

import com.example.software_engineer.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JSONRepository {
    private List<Account> accountList;

    public JSONRepository(){

    }

}
