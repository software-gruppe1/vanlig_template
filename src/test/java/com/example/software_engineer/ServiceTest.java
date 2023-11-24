package com.example.software_engineer;

import com.example.software_engineer.model.Reviews;
import com.example.software_engineer.model.Services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

public class ServiceTest {
    @Nested
    class placeReviewTest{
        @Test
        public void isPlaceReviewMethodWorking() {
            // Opprett en ny service-instans
            Services service = new Services();
            // lage en anmeldelse
            Reviews review_text = new Reviews("Joe", "Best service!", 10);

            //legge_til_anmeldelse
            service.placeReview(review_text);

            // Sjekk at anmeldelsen ble lagt til
            Assertions.assertEquals("Best service!", service.getAll_reviews().get(0).getReview());
        }
    }
}




