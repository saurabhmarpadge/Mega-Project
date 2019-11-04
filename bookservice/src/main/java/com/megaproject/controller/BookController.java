package com.megaproject.controller;

import com.megaproject.dto.BookRequest;
import com.megaproject.entity.Book;
import com.megaproject.service.BookService;
import com.megaproject.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-service/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value =  "/{book_id}")
    public ResponseEntity<Book> getBook(@PathVariable(value = "book_id") Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.getBook(id));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooks());
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody BookRequest bookRequest){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.addBook(bookRequest));
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody BookRequest bookRequest){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(bookRequest));
    }

    @DeleteMapping(value = "/{book_id}")
    public ResponseEntity<Object> deleteBook(@PathVariable(value = "book_id") Long id){
        bookService.removeBook(id);
        return ResponseEntity.ok().build();
    }
}
