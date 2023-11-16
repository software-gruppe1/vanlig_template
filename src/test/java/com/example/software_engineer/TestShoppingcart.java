package com.example.software_engineer;

import com.example.software_engineer.model.Reviews;
import com.example.software_engineer.model.Services;
import com.example.software_engineer.model.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class TestShoppingcart {
    ShoppingCart shoppingCart;
    @BeforeEach
    public void setUp() {
        // Create an instance of ShoppingCart before each test
        shoppingCart = new ShoppingCart();
    }
    @Nested
    class add_to_shoppingcart1{
        @Test

        public void isServiceinShoppingCart() {
            Services serviceInfo1 = new Services("Cowabonga", LocalDate.of(2003, 2, 15), 165,
                    "Awesome place", "Norway", "ayubs", "123DSASDsf");

            shoppingCart.add_services(serviceInfo1, serviceInfo1.getUID());

            Assertions.assertEquals(165, shoppingCart.getTotalPrice() );
            Assertions.assertEquals(1, shoppingCart.getServices().size());

        }
    }

    @Nested
    class delete_service{
        @Test

        public void delete_from_shoppingcartTEST() {
            Services serviceInfo1 = new Services("Cowabonga", LocalDate.of(2003, 2, 15), 165,
                    "Awesome place", "Norway", "ayubs", "123DSASDsf");

            shoppingCart.add_services(serviceInfo1, serviceInfo1.getUID());

            //Har testet denne metoden tidligere, så jeg vet hva som skjer

            shoppingCart.delete_service(serviceInfo1, serviceInfo1.getUID());

            Assertions.assertEquals(0, shoppingCart.getTotalPrice());
            Assertions.assertEquals(0, shoppingCart.getServices().size());
        }




    }
    @Nested
    class clearShoppingcartTEST {
        @Test
        public void hasALLServicesleftShoppingCart() {






            //Lager et objekt for å bruke og teste den
            Services serviceInfo1 = new Services("Cowabonga", LocalDate.of(2003, 2, 15), 165,
                    "Awesome place", "Norway", "ayubs", "123DSASDsf");
            Services serviceInfo2 = new Services("Bongacowa", LocalDate.of(2001, 11, 9), 5000,
                    "horrible place", "France", "sbuya", "321DSASDfs");

            //legger til objekten inn i arraylisten
            shoppingCart.add_services(serviceInfo1, serviceInfo1.getUID());
            shoppingCart.add_services(serviceInfo2, serviceInfo2.getUID());
            //Har en if test som verifiserer om den har blitt lagt til så skal totalprisen oppdatere seg.

            Assertions.assertEquals(2, shoppingCart.getServices().size());
            Assertions.assertEquals(5165, shoppingCart.getTotalPrice());

            //Andre ordentlig test uten å lage en metode!
            //Dette er en test for en metode som skal slette en service fra en arraylist
            shoppingCart.delete_shoppingcart();

            Assertions.assertEquals(0, shoppingCart.getServices().size());
            Assertions.assertEquals(0, shoppingCart.getTotalPrice());

            //Virker som at jeg faktisk ikke har brukt metoden i det hele tatt som jeg tenker er litt feil
            //Gjorde ikke det på første test heller.

        }

    }



}
