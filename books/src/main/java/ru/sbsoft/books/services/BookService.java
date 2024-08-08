package ru.sbsoft.books.services;

import ru.sbsoft.books.dto.Book;

import java.util.List;

public interface BookService {

    List<Book> findAllBooks();

    Book findBookById(Long bookId);

    Book createBook(Book book);

    void deleteBook(Long bookId);

    Book updateBook(Book book, Long bookId);
}
