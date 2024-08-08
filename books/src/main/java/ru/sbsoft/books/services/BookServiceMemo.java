package ru.sbsoft.books.services;

import lombok.val;
import org.springframework.stereotype.Service;
import ru.sbsoft.books.dto.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceMemo implements BookService {

    private final Map<Long, Book> storage = new HashMap<>();
    private long nextId = 1L;

    public BookServiceMemo() {
        val book1 = new Book(nextId++, "Война и мир", "Толстой");
        storage.put(book1.getId(), book1);
        val book2 = new Book(nextId++, "Сияние", "Кинг");
        storage.put(book2.getId(), book2);
    }

    @Override
    public List<Book> findAllBooks() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Book findBookById(Long bookId) {
        return storage.get(bookId);
    }

    @Override
    public Book createBook(Book book) {
        book.setId(nextId++);
        storage.put(book.getId(), book);
        return book;
    }

    @Override
    public void deleteBook(Long bookId) {
        storage.remove(bookId);
    }

    @Override
    public Book updateBook(Book book, Long bookId) {
        book.setId(bookId);
        storage.put(bookId, book);
        return book;
    }
}
