package com.megaproject.fallback;

import com.megaproject.client.BookClient;
import com.megaproject.model.Book;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class BookClientFallback implements BookClient {
    @Override
    public List<Book> getAllBooks() {
        return Arrays.asList(Book.builder().bookName("Error").build());
    }
}
