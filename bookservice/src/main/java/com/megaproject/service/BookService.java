package com.megaproject.service;

import com.megaproject.dto.BookRequest;
import com.megaproject.entity.Book;

import java.util.List;

public interface BookService {
    public Book addBook(BookRequest bookRequest);

    public List<Book> getBooks();

    public Book getBook(Long id);

    public void removeBook(Long id);

    public Book updateBook(BookRequest bookRequest);
}
