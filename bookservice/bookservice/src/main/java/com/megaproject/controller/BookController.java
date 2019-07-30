package com.megaproject.controller;

import com.megaproject.dto.BookRequest;
import com.megaproject.entity.Book;
import com.megaproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-service/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.getBook(id);
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @PostMapping
    public Book saveBook(@RequestBody BookRequest bookRequest){
        return bookService.saveBook(bookRequest);
    }

    @PutMapping
    public Book updateBook(@RequestBody BookRequest bookRequest){
        return bookService.updateBook(bookRequest);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }
}
