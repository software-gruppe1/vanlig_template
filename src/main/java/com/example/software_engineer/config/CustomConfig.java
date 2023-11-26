package com.example.software_engineer.config;

import com.example.software_engineer.repository.JSONRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class CustomConfig {

    @Bean
    @Primary
    public JSONRepository jsonRepository() {
        return new JSONRepository("src/main/java/com/example/software_engineer/data/account.json", "src/main/java/com/example/software_engineer/data/services.json");
    }
}
