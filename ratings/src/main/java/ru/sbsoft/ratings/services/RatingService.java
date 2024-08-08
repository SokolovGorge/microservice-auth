package ru.sbsoft.ratings.services;

import ru.sbsoft.ratings.dto.Rating;

import java.util.List;

public interface RatingService {

    List<Rating> findAllRatings();

    List<Rating> findRatingsByBookId(Long bookId);

    Rating createRating(Rating rating);

    void deleteRating(Long ratingId);

    Rating updateRating(Rating rating, Long ratingId);
}
