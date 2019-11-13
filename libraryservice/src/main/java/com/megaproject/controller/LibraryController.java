package com.megaproject.controller;

import com.megaproject.model.Book;
import com.megaproject.model.User;
import com.megaproject.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/library-service/lib")
public class LibraryController {

    private static final Logger LOGGER = Logger.getLogger(LibraryController.class.getName());

    @Autowired
    @Resource(name = "${api.version}")
    private LibraryService libraryService;

    @GetMapping
    public ResponseEntity<User> login(@PathVariable Long id){
        LOGGER.info("Calling login");
        return ResponseEntity.ok().body(libraryService.getUser(id));
    }

    @GetMapping(value = "/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        LOGGER.info("Calling getAllBooks");
        return ResponseEntity.ok().body(libraryService.getBooks());
    }

    @GetMapping(value = "/books/{book_id}")
    public ResponseEntity<Book> getBook(@PathVariable(value = "book_id") Long id){
        LOGGER.info("Calling getBook");
        return ResponseEntity.ok().body(libraryService.getBook(id));
    }

    @PostMapping(value = "/books/{book_id}")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        LOGGER.info("Calling addBook");
        return ResponseEntity.ok().body(libraryService.addBook(book));
    }

    @DeleteMapping(value = "/books/{book_id}")
    public ResponseEntity<Object> removeBook(@PathVariable(value = "book_id") Long id) {
        LOGGER.info("Calling removeBook");
        libraryService.removeBook(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUsers(){
        LOGGER.info("Calling getAllUsers");
        return ResponseEntity.ok().body(libraryService.getUsers());
    }

    @GetMapping(value = "/users/{user_id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "user_id") Long id){
        LOGGER.info("Calling getUser");
        return ResponseEntity.ok().body(libraryService.getUser(id));
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> addUser(@RequestBody User user){
        LOGGER.info("Calling addUser");
        return ResponseEntity.ok().body(libraryService.addUser(user));
    }

    @DeleteMapping(value = "/users/{user_id}")
    public ResponseEntity<Object> removeUser(@PathVariable(value = "user_id") Long id) {
        LOGGER.info("Calling removeUser");
        libraryService.removeUser(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/users/{user_id}")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        LOGGER.info("Calling updateUser");
        return ResponseEntity.ok().body(libraryService.updateUser(user));
    }

    @PutMapping(value = "/users/{user_id}/books/{book_id}")
    public ResponseEntity<Object> issueBook(@PathVariable(value = "user_id") Long userId, @PathVariable(value = "book_id") Long bookId){
        LOGGER.info("Calling issueBook");
        libraryService.issueBook(bookId,userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
