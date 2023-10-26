package com.example.software_engineer;

import com.example.software_engineer.model.Reviews;
import com.example.software_engineer.model.Services;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Reviewstest {
    @Nested
    class placeRatingTest{
        @Test
        public void isPlaceRatingMethodWorking() {
            Services review = new Services();
            Reviews review_rating = new Reviews("Joe", "Best service!", 5);
            review.placeReview(review_rating);
            Assertions.assertEquals(5, review.getAll_reviews().get(0).getRate());
        }
    }
}
