package com.example.software_engineer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String accountPath() {
        return "src/main/java/com/example/software_engineer/data/account.json";
    }

    @Bean
    public String servicePath() {
        return "src/main/java/com/example/software_engineer/data/services.json";
    }
}
