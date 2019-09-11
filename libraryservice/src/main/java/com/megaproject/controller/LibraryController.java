package com.megaproject.controller;

import com.megaproject.client.BookClient;
import com.megaproject.model.Book;
import com.megaproject.config.UrlHolder;
import com.megaproject.model.User;
import com.megaproject.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/library-service/lib")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @Autowired
    UrlHolder esbHolder;

    @Autowired
    BookClient bookClient;


    @GetMapping
    public User login(@PathVariable Long id){
        Map< String, String > params = new HashMap<>();
        params.put("user_id", id.toString());
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(esbHolder.userId, User.class, params);
        return user;
    }

    @GetMapping(value = "/books/books")
    public List<Book> getAllBookss(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(esbHolder.bookUrl,  Book[].class).getBody();


    }

    @GetMapping(value = "/books")
    public List<Book> getAllBooks(){
        return bookClient.getAllBooks();
    }

    @GetMapping(value = "/books/{book_id}")
    public Book getBook(@PathVariable(value = "book_id") Long id){
        Map< String, String > params = new HashMap<>();
        params.put("book_id", id.toString());
        RestTemplate restTemplate = new RestTemplate();
        Book book = restTemplate.getForObject(esbHolder.bookId, Book.class, params);
        return book;
    }

    @PostMapping(value = "/books/{book_id}")
    public Book addBook(@RequestBody Book book){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(esbHolder.bookUrl, book,Book.class).getBody();
    }

    @DeleteMapping(value = "/books/{book_id}")
    public void removeBook(@PathVariable(value = "book_id") Long id) {
        Map< String, String > params = new HashMap<>();
        params.put("user_id", id.toString());
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(esbHolder.bookId,params);
    }

    @GetMapping(value = "/users")
    public User getAllUsers(){
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(esbHolder.userUrl, User.class);
        return user;
    }

    @GetMapping(value = "/users/{user_id}")
    public User getUser(@PathVariable(value = "user_id") Long id){
        Map< String, String > params = new HashMap<>();
        params.put("user_id", id.toString());
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(esbHolder.userId, User.class, params);
        return user;
    }

    @PostMapping(value = "/users")
    public User addUser(@RequestBody User user){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(esbHolder.bookUrl, user,User.class).getBody();
    }
    @DeleteMapping(value = "/users/{user_id}")
    public void removeUser(@PathVariable(value = "user_id") Long id) {
        Map< String, String > params = new HashMap<>();
        params.put("user_id", id.toString());
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(esbHolder.userId,params);
    }

    @PutMapping(value = "/users/{user_id}")
    public void updateUser(@RequestBody User user){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(esbHolder.userUrl,user,User.class);
    }

    @PutMapping(value = "/users/{user_id}/books/{book_id}")
    public ResponseEntity<Object> issueBook(@PathVariable(value = "user_id") Long userId, @PathVariable(value = "book_id") Long bookId){
        libraryService.issueBook(bookId,userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
