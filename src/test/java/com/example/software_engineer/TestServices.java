package com.example.software_engineer;

import com.example.software_engineer.model.Services;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ReviewTest {
    @Test
    public void testPlaceReview() {
        // Opprett en ny Review-instans
        Services review = new Services();
        // Legg til en anmeldelse
        review.placeReview("Best service!");
        // Sjekk at anmeldelsen ble lagt til
        Assertions.assertEquals("Best service!", review.getReviews().get(0));
    }
}

class RatingTest {
    @Test
    void testPlaceRating() {
        // Opprett en ny Rating-instans
        Services rating = new Services();
        // Legg til en vurdering
        rating.placeRating(5);
        // Sjekk at vurderingen ble lagt til
        Assertions.assertEquals(5, rating.getRating().get(0));
    }
}




