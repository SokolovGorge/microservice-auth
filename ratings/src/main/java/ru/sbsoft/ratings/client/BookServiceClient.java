package ru.sbsoft.ratings.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.sbsoft.ratings.dto.Book;

@Component
@RequiredArgsConstructor
public class BookServiceClient implements BookService {

    private final RestTemplate restTemplate;

    @Override
    public Book findBook(Long bookId) {
        return restTemplate.getForObject("http://BOOKS-APP/books/" + bookId, Book.class);
    }

}
