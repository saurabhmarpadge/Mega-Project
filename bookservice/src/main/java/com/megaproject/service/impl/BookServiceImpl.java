package com.megaproject.service.impl;

import com.megaproject.dto.BookRequest;
import com.megaproject.entity.Book;
import com.megaproject.repository.BookRepository;
import com.megaproject.service.BookService;
import com.sun.jersey.api.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setBookId(bookRequest.getBookId());
        book.setBookName(bookRequest.getBookName());
        book.setAuthor(bookRequest.getAuthor());
        book.setIsbn(bookRequest.getIsbn());
        return bookRepository.save(book);
    }

    @Override
    public Book getBook(Long id) {
        if (!bookRepository.existsById(id))
            throw new NotFoundException("Book Not Found");

        Optional<Book> book = bookRepository.findById(id);
        return book.isPresent()?book.get():null;
    }

    @Override
    public void removeBook(Long id) {
        if (!bookRepository.existsById(id))
            throw new NotFoundException("Book Not Found");
        bookRepository.deleteById(id);
    }

    @Override
    public Book updateBook(BookRequest bookRequest) {
        if (!bookRepository.existsById(bookRequest.getBookId()))
            throw new NotFoundException("Book Not Found");
        Book bookUpdate = bookRepository.getOne(bookRequest.getBookId());
        bookUpdate.setBookName(bookRequest.getBookName());
        bookUpdate.setAuthor(bookRequest.getAuthor());
        bookUpdate.setIsbn(bookRequest.getIsbn());
        bookUpdate.setPrice(bookRequest.getPrice());
        return bookRepository.save(bookUpdate);
    }

}
