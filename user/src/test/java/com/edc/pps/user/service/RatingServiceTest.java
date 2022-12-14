package com.edc.pps.user.service;

import com.edc.pps.user.dto.rating.RatingMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RatingServiceTest {

    @InjectMocks
    private RatingService ratingService;

    @Mock
    private RatingRepository ratingrepository;

    @Mock
    private RatingMapper ratingMapper;

    @Test
    void givenRatingRequest_whenSaveOrUpdate_thenReturnRatingResponse() {

    }

    @Test
    void whenFindAll_thenReturnRatingResponseList() {
    }

    @Test
    void delete() {
    }

    @Test
    void givenBookId_whenGetAllRatingsForBook_thenReturnRatingResponseList() {
    }
}