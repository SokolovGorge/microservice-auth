package ru.sbsoft.ratings.client;

import ru.sbsoft.ratings.dto.Book;

public interface BookService {

    public Book findBook(Long bookId);
}
