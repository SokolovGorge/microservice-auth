package ru.sbsoft.ratings.services;

import lombok.val;
import org.springframework.stereotype.Service;
import ru.sbsoft.ratings.dto.Rating;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RatingServiceMemo implements RatingService {

    private final Map<Long, Rating> storage = new HashMap<>();
    private long nextId = 1L;

    public RatingServiceMemo() {
        val rating1 = new Rating(nextId++, 1L, 5);
        storage.put(rating1.getId(), rating1);
        val rating2 = new Rating(nextId++, 2L, 4);
        storage.put(rating2.getId(), rating2);
    }

    @Override
    public List<Rating> findAllRatings() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public List<Rating> findRatingsByBookId(Long bookId) {
        return storage.values().stream().filter(p -> Objects.equals(p.getBookId(), bookId)).collect(Collectors.toList());
    }

    @Override
    public Rating createRating(Rating rating) {
        rating.setId(nextId++);
        storage.put(rating.getId(), rating);
        return rating;
    }

    @Override
    public void deleteRating(Long ratingId) {
        storage.remove(ratingId);
    }

    @Override
    public Rating updateRating(Rating rating, Long ratingId) {
        rating.setId(ratingId);
        storage.put(ratingId, rating);
        return rating;
    }
}
