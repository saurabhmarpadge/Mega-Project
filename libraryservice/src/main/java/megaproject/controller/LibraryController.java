package megaproject.controller;

import megaproject.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library-service/lib")
public class LibraryController {
    @Autowired
    private LibraryService bookService;

    @GetMapping
    public void login(@PathVariable Long id){
    }

    @GetMapping(value = "/books")
    public void getAllBooks(){
    }

    @GetMapping(value = "/books/{book_id}")
    public void getBook(){

    }

    @PostMapping(value = "/books/{book_id}")
    public void addBook(){

    }
    @DeleteMapping(value = "/books/{book_id}")
    public void removeBook() {


    }

    @GetMapping(value = "/users")
    public void getAllUsers(){

    }

    @GetMapping(value = "/users/{user_id}")
    public void getUser(){

    }

    @PostMapping(value = "/users/{user_id}")
    public void addUser(){

    }
    @DeleteMapping(value = "/users/{user_id}")
    public void removeUser() {
    }

    @PutMapping(value = "/users/{user_id}")
    public void updateUser(){
    }

    @PutMapping(value = "/users/{user_id}/books/{book_id}")
    public void issueBook(){
    }

}
