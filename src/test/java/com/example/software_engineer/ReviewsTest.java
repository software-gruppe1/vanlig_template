package com.example.software_engineer;

import com.example.software_engineer.model.Reviews;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReviewsTest {
    @Nested
    class placeRatingTest1{
        @Test
        public void isPlacingLegalRatingsWorking() {
            Reviews review_rating = new Reviews("Joe", "Best service!", 1);
            review_rating.setRate(5);
            Assertions.assertEquals(5, review_rating.getRate());


        }

        @Test
        public void isPlacingIllegalRatingWorking(){
            Reviews review_rating = new Reviews("Joe", "Worst service!", 4);

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                review_rating.setRate(11);
                review_rating.setRate(-1);
            });

            // Optionally, you can assert details about the exception, if needed
            Assertions.assertEquals("You can only rate from 1 to 10!", exception.getMessage());
        }


    }
}

