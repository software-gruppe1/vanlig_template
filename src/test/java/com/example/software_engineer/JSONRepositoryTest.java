package com.example.software_engineer;

import com.example.software_engineer.model.Account;
import com.example.software_engineer.model.Services;
import com.example.software_engineer.model.ShoppingCart;
import com.example.software_engineer.repository.JSONRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class JSONRepositoryTest {
    private List<Account> accountList;
    private List<Services> servicesList;
    private JSONRepository jsonRepository;

    @BeforeEach
    public void init(){
        accountList = new ArrayList<>();
        servicesList = new ArrayList<>();
        Account user = new Account("Ole Nordmann", "User123", "ole_nordmann@gmail.com", "User");
        Account admin = new Account("Ali A", "Admin123", "ali_a@gmail.com", "Admin");
        accountList.add(user);
        accountList.add(admin);

        Services service1 = new Services("museum of egypt", LocalDate.of(2023, 12, 23), 699, "A beautiful museum stolen by the british", "Admin", "1");
        Services service2 = new Services("city guide in paris", LocalDate.of(2024, 2, 15), 999, "a wonderful guide", "User", "2");
        Services service3 = new Services("bungee jumping in Norway", LocalDate.of(2025, 6, 15), 500, "Jump to your death, it's at least fun", "Admin", "3");

        servicesList.add(service1);
        servicesList.add(service2);
        servicesList.add(service3);

        jsonRepository = new JSONRepository("src/test/java/com/example/software_engineer/dataTest/accountTest.json", "src/test/java/com/example/software_engineer/dataTest/servicesTest.json", accountList, servicesList);
    }
    @Nested
    class allServicesTest {
        @Test
        public void correctAllServices() {
            assertEquals(jsonRepository.allServices().toString(), servicesList.toString());
        }

        @Test
        public void incorrectAllServices(){
            assertNotEquals(jsonRepository.allServices().toString(), accountList.toString());
        }
    }

    @Nested
    class allAccountTest {
        @Test
        public void correctAllAccount() {
            assertEquals(jsonRepository.allAccount().toString(), accountList.toString());
        }

        @Test
        void incorrectAllAccount(){
            assertNotEquals(jsonRepository.allAccount().toString(), servicesList.toString());
        }
    }

    @Nested
    class spesificServiceTest {
        @Test
        public void correctSpesificService() {
            assertEquals(jsonRepository.spesificService("1",1).toString(), servicesList.get(0).toString());
        }
        @Test
        public void incorrectSpesificService(){
            assertNotEquals(jsonRepository.spesificService("1",1).toString(), servicesList.get(1).toString());
        }
    }

    @Nested
    class spesificAccountTest {
        @Test
        public void correctSpesificAccount() {
            assertEquals(jsonRepository.spesificAccount("User").toString(), accountList.get(0).toString());
        }
        @Test
        public void incorrectSpesificAccount(){
            assertNotEquals(jsonRepository.spesificAccount("User").toString(), accountList.get(1).toString());
        }
    }

   /* @Nested
    class deleteServiceTest{
        @Test
        public void isServiceDeleted(){
            jsonRepository.deleteService("User", "2");
            //System.out.println(jsonRepository.spesificService("2"));
            assertNull(jsonRepository.spesificService("2",1));
        }
    }*/
}
