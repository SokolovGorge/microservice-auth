package ru.sbsoft.ratings.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sbsoft.ratings.client.BookService;
import ru.sbsoft.ratings.dto.Book;
import ru.sbsoft.ratings.services.RatingService;
import ru.sbsoft.ratings.dto.Rating;

import java.util.List;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;
    private final BookService bookService;


    @GetMapping
    public List<Rating> findRatingsByBookId(
            @RequestParam(required = false, defaultValue = "0") Long bookId) {
       if (bookId.equals(0L)) {
           return ratingService.findAllRatings();
       }
       return ratingService.findRatingsByBookId(bookId);
    }

    @PostMapping
    public Rating createRating(@RequestBody Rating rating) {
        return  ratingService.createRating(rating);
    }

    @DeleteMapping("/{ratingId}")
    public void deleteRating(@PathVariable Long ratingId) {
        ratingService.deleteRating(ratingId);
    }

    @PutMapping("/{ratingId}")
    public Rating updateRating(@RequestBody Rating rating, @PathVariable Long ratingId) {
        return ratingService.updateRating(rating, ratingId);
    }

    @GetMapping("/books/{bookId}")
    public Book findBook(@PathVariable Long bookId) {
        return bookService.findBook(bookId);
    }
}
