package com.megaproject.controller;

import com.megaproject.dto.BookRequest;
import com.megaproject.entity.Book;
import com.megaproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/book-service/books")
public class BookController {

    private static final Logger LOGGER = Logger.getLogger(BookController.class.getName());

    @Autowired
    private BookService bookService;

    @GetMapping(value =  "/{book_id}")
    public ResponseEntity<Book> getBook(@PathVariable(value = "book_id") Long id){
        LOGGER.info("Calling getBook");
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.getBook(id));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        LOGGER.info("Calling getAllBooks");
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooks());
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody BookRequest bookRequest){
        LOGGER.info("Calling addBook");
        return ResponseEntity.status(HttpStatus.OK).body(bookService.addBook(bookRequest));
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody BookRequest bookRequest){
        LOGGER.info("Calling updateBook");
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(bookRequest));
    }

    @DeleteMapping(value = "/{book_id}")
    public ResponseEntity<Object> deleteBook(@PathVariable(value = "book_id") Long id){
        LOGGER.info("Calling deleteBook");
        bookService.removeBook(id);
        return ResponseEntity.ok().build();
    }
}
