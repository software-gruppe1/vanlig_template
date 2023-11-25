package com.example.software_engineer;

import com.example.software_engineer.model.*;
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

        Services service1 = new Services("museum of egypt", LocalDate.of(2023, 12, 23), 699, "A beautiful museum stolen by the british", "Egypt", "Admin", "1");
        Services service2 = new Services("city guide in paris", LocalDate.of(2024, 2, 15), 999, "a wonderful guide","France", "User", "2");
        Services service3 = new Services("bungee jumping in Norway", LocalDate.of(2025, 6, 15), 500, "Jump to your death, it's at least fun", "Norway", "Admin", "3");

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
            assertEquals(jsonRepository.spesificService("1").toString(), servicesList.get(0).toString());
        }
        @Test
        public void incorrectSpesificService(){
            assertNotEquals(jsonRepository.spesificService("1").toString(), servicesList.get(1).toString());
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

    @Nested
    class deleteServiceTest{
        @Test
        public void isServiceDeleted(){
            jsonRepository.deleteService("User", "2");
            //System.out.println(jsonRepository.spesificService("2"));
            assertNull(jsonRepository.spesificService("2"));
        }

        @Test
        public void canUnauthorizedAccountNotDeleteService(){
            jsonRepository.deleteService("User", "1");
            assertNotNull(jsonRepository.spesificService("1"));
        }
    }

    @Nested
    class createServiceTest{
        @Test
        public void isServiceCreated(){
            Services service = new Services("Hiking", LocalDate.of(2023, 6, 25), 420, "Wonderful hiking to boost your energy", "Sweden", "Admin", "4");
            jsonRepository.createService("Hiking", "Wonderful hiking to boost your energy", "Sweden", LocalDate.of(2023, 6, 25), 420, "Admin", "4");
            assertEquals(service.toString(), jsonRepository.spesificService("4").toString());
        }
    }

    @Nested
    class changeServiceTest{
        @Test
        public void isServiceChanged(){
            Services services = jsonRepository.spesificService("1");
            System.out.println("Changed from: "+services.toString());
            jsonRepository.changeService("Swimming", "Wonderful swimming to boost your energy", "Greece", LocalDate.of(2023, 6, 25), 100, "Admin", "1");
            assertNotSame(jsonRepository.spesificService("1").toString(), services.toString());
        }

        @Test
        public void isServiceChangedByUser(){
            Services services = jsonRepository.spesificService("2");
            System.out.println("Changed from: "+services.toString());
            jsonRepository.changeService("Swimming", "Wonderful swimming to boost your energy", "Greece", LocalDate.of(2023, 6, 25), 100, "User", "2");
            assertNotSame(jsonRepository.spesificService("2").toString(), services.toString());
        }
        @Test
        public void isServiceNotChangedBecauseWrongUser(){
            Services services = jsonRepository.spesificService("1");
            System.out.println("Changed from: "+services.toString());
            jsonRepository.changeService("Swimming", "Wonderful swimming to boost your energy", "Greece", LocalDate.of(2023, 6, 25), 100, "User", "1");
            assertEquals(jsonRepository.spesificService("1").toString(), services.toString());
        }
    }

    @Nested
    class addReviewTest{
        @Test
        public void isReviewAdded(){
            Reviews review = new Reviews("Ole", "This stinks", 3);
            jsonRepository.addReview("1", review);
            assertEquals(jsonRepository.spesificService("1").getAll_reviews().get(0).toString(), review.toString());
        }
    }

    @Nested
    class addInShoppingcartTest{
        @Test
        public void isServiceInShoppingCart(){
            jsonRepository.addInShoppingcart("User", "2");
            assertEquals("2", jsonRepository.spesificAccount("User").getShopping_cart().getServices().get(0));
        }
    }

    @Nested
    class deleteShoppingcartTest{
        @Test
        public void isShoppingCartDeleted(){
            jsonRepository.addInShoppingcart("User", "2");
            jsonRepository.addInShoppingcart("User", "3");
            String shoppingcart = jsonRepository.spesificAccount("User").getShopping_cart().toString();
            jsonRepository.deleteShoppingCart("User");
            assertNotEquals(shoppingcart, jsonRepository.spesificAccount("User").getShopping_cart().toString());
        }

        @Test
        public void isShoppingCartNotDeleted(){
            jsonRepository.addInShoppingcart("User", "2");
            jsonRepository.addInShoppingcart("User", "3");
            String shoppingcart = jsonRepository.spesificAccount("User").getShopping_cart().toString();
            jsonRepository.deleteShoppingCart("Admin");
            assertEquals(shoppingcart, jsonRepository.spesificAccount("User").getShopping_cart().toString());
        }
    }

    @Nested
    class deleteOneServiceFromShoppingcartTest{
        @Test
        public void isServiceDeletedFromShoppingcart(){
            jsonRepository.addInShoppingcart("Admin", "2");
            jsonRepository.addInShoppingcart("Admin", "3");
            jsonRepository.deleteOneServiceFromShoppingcart("Admin", "3");
            assertTrue(jsonRepository.spesificAccount("Admin").getShopping_cart().getServices().contains("2"));
            assertFalse(jsonRepository.spesificAccount("Admin").getShopping_cart().getServices().contains("3"));
        }
    }

    @Nested
    class createOrderTest{
        @Test
        public void isOrderCreated(){
            jsonRepository.addInShoppingcart("Admin", "2");
            jsonRepository.addInShoppingcart("Admin", "3");
            ArrayList<OrderServiceDetail> orderServiceDetails = new ArrayList<>();
            orderServiceDetails.add(new OrderServiceDetail("city guide in paris", 999));
            orderServiceDetails.add(new OrderServiceDetail("bungee jumping in Norway", 500));
            jsonRepository.createOrder("Admin");
            assertEquals(orderServiceDetails.toString(), jsonRepository.spesificAccount("Admin").getOrder().get(0).getServices().toString());
            assertEquals(1499, jsonRepository.spesificAccount("Admin").getOrder().get(0).getTotalPrice());
        }
    }
}
