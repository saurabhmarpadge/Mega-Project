package com.megaproject.service;

import com.megaproject.dto.BookRequest;
import com.megaproject.entity.Book;
import com.megaproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setBookId(bookRequest.getBookId());
        book.setBookName(bookRequest.getBookName());
        book.setAuthor(bookRequest.getAuthor());
        book.setIsbn(bookRequest.getIsbn());
        return bookRepository.save(book);
    }

    public Book getBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.isPresent()?book.get():null;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(BookRequest bookRequest) {
        Book bookUpdate = bookRepository.getOne(bookRequest.getBookId());
        bookUpdate.setBookName(bookRequest.getBookName());
        bookUpdate.setAuthor(bookRequest.getAuthor());
        bookUpdate.setIsbn(bookRequest.getIsbn());
        return bookRepository.save(bookUpdate);
    }
}
