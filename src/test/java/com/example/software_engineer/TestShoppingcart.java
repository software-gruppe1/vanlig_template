package com.example.software_engineer;

import com.example.software_engineer.model.Reviews;
import com.example.software_engineer.model.Services;
import com.example.software_engineer.model.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class TestShoppingcart {

    @Nested
    class add_to_shoppingcart{
        @Test
        public void isServiceinShoppingCart() {
            //Gjør totalprice til 0 fordi shoppingcarten skal starte med 0
            int totalprice= 0;
            //Lager en arraylist for serviceUID
            ArrayList<String> servicesUID = new ArrayList<>();

            //Lager et objekt for å bruke og teste den
            Services serviceInfo = new Services("Cowabonga", LocalDate.of(2003, 2, 15), 165,
                    "Awesome place","Norway", "ayubs", "123DSASDsf");

            //legger til objekten inn i arraylisten
            servicesUID.add(serviceInfo.getUID());

            //Har en if test som verifiserer om den har blitt lagt til så skal totalprisen oppdatere seg.
            if (servicesUID.add(serviceInfo.getUID())){
                totalprice+= serviceInfo.getPrice();
            }

            //TESTENE
            Assertions.assertEquals(servicesUID.get(0), serviceInfo.getUID() );
            Assertions.assertEquals(165, totalprice);



        }


    }
    @Nested
    class delete_from_shoppingcartTEST {
        @Test
        public void hasServiceleftShoppingCart() {
            //tenker å bruke en del av min forje test på denne testen.
            int totalprice= 0;

            ArrayList<String> servicesUID = new ArrayList<>();


            //Lager et objekt for å bruke og teste den
            Services serviceInfo1 = new Services("Cowabonga", LocalDate.of(2003, 2, 15), 165,
                    "Awesome place", "Norway", "ayubs", "123DSASDsf");

            //legger til objekten inn i arraylisten
            servicesUID.add(serviceInfo1.getUID());
            //Har en if test som verifiserer om den har blitt lagt til så skal totalprisen oppdatere seg.
            if (servicesUID.add(serviceInfo1.getUID())){
                totalprice+= serviceInfo1.getPrice();
            }
            Assertions.assertEquals(servicesUID.get(0), serviceInfo1.getUID() );
            Assertions.assertEquals(165, totalprice);

            //Første ordentlig test uten å lage en metode!
            //Dette er en test for en metode som skal slette en service fra en arraylist
            servicesUID.remove(serviceInfo1.getUID());

            if(servicesUID.remove(serviceInfo1.getUID())){
                totalprice-=serviceInfo1.getPrice();
            }

            Assertions.assertEquals(0, servicesUID.size());
            Assertions.assertEquals(0, totalprice);

            //Virker som at jeg faktisk ikke har brukt metoden i det hele tatt som jeg tenker er litt feil
            //Gjorde ikke det på første test heller.

        }

    }
    @Nested
    class clearShoppingcartTEST {
        @Test
        public void hasALLServicesleftShoppingCart() {
            //tenker å bruke en del av min forje test på denne testen.
            int totalprice= 0;

            ArrayList<String> servicesUID = new ArrayList<>();


            //Lager et objekt for å bruke og teste den
            Services serviceInfo1 = new Services("Cowabonga", LocalDate.of(2003, 2, 15), 165,
                    "Awesome place", "Norway", "ayubs", "123DSASDsf");
            Services serviceInfo2 = new Services("Bongacowa", LocalDate.of(2001, 11, 9), 5000,
                    "horrible place", "France", "sbuya", "321DSASDfs");

            //legger til objekten inn i arraylisten
            servicesUID.add(serviceInfo1.getUID());
            servicesUID.add(serviceInfo2.getUID());
            //Har en if test som verifiserer om den har blitt lagt til så skal totalprisen oppdatere seg.

            totalprice+= serviceInfo1.getPrice(); //Må lage en for loop her


            totalprice+= serviceInfo2.getPrice(); //Må putte disse i en for loop med metoden.


            Assertions.assertEquals(2, servicesUID.size());
            Assertions.assertEquals(5165, totalprice);

            //Andre ordentlig test uten å lage en metode!
            //Dette er en test for en metode som skal slette en service fra en arraylist
            servicesUID.clear();

            if(servicesUID.isEmpty()){
                totalprice= 0;
            }

            Assertions.assertEquals(0, servicesUID.size());
            Assertions.assertEquals(0, totalprice);

            //Virker som at jeg faktisk ikke har brukt metoden i det hele tatt som jeg tenker er litt feil
            //Gjorde ikke det på første test heller.

        }

    }
}
