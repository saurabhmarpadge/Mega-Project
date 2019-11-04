package com.megaproject.controller;

import com.megaproject.config.UrlHolder;
import com.megaproject.model.Book;
import com.megaproject.model.User;
import com.megaproject.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/library-service/lib")
public class LibraryController {

    @Autowired
    @Resource(name = "${api.version}")
    private LibraryService libraryService;

    @GetMapping
    public ResponseEntity<User> login(@PathVariable Long id){
        return ResponseEntity.ok().body(libraryService.getUser(id));
    }

    @GetMapping(value = "/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok().body(libraryService.getBooks());
    }

    @GetMapping(value = "/books/{book_id}")
    public ResponseEntity<Book> getBook(@PathVariable(value = "book_id") Long id){
        return ResponseEntity.ok().body(libraryService.getBook(id));
    }

    @PostMapping(value = "/books/{book_id}")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return ResponseEntity.ok().body(libraryService.addBook(book));
    }

    @DeleteMapping(value = "/books/{book_id}")
    public ResponseEntity<Object> removeBook(@PathVariable(value = "book_id") Long id) {
        libraryService.removeBook(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(libraryService.getUsers());
    }

    @GetMapping(value = "/users/{user_id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "user_id") Long id){
        return ResponseEntity.ok().body(libraryService.getUser(id));
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok().body(libraryService.addUser(user));
    }
    @DeleteMapping(value = "/users/{user_id}")
    public ResponseEntity<Object> removeUser(@PathVariable(value = "user_id") Long id) {
        libraryService.removeUser(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/users/{user_id}")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return ResponseEntity.ok().body(libraryService.updateUser(user));
    }

    @PutMapping(value = "/users/{user_id}/books/{book_id}")
    public ResponseEntity<Object> issueBook(@PathVariable(value = "user_id") Long userId, @PathVariable(value = "book_id") Long bookId){
        libraryService.issueBook(bookId,userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
