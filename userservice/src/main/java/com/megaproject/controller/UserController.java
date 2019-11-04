package com.megaproject.controller;

import com.megaproject.dto.UserRequest;
import com.megaproject.entity.User;
import com.megaproject.service.UserService;
import com.megaproject.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-service/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping(value = "/{user_id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "user_id") Long id){
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok().body(userService.addUser(userRequest));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok().body(userService.updateUser(userRequest));
    }

    @DeleteMapping(value = "/{user_id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "user_id") Long id){
        userService.removeUser(id);
        return ResponseEntity.ok().build();
    }
}
