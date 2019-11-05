package com.megaproject.controller;

import com.megaproject.dto.UserRequest;
import com.megaproject.entity.User;
import com.megaproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user-service/users")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping(value = "/{user_id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "user_id") Long id){
        LOGGER.info("Calling getUser");
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody UserRequest userRequest){
        LOGGER.info("Calling addUser");
        return ResponseEntity.ok().body(userService.addUser(userRequest));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody UserRequest userRequest){
        LOGGER.info("Calling updateUser");
        return ResponseEntity.ok().body(userService.updateUser(userRequest));
    }

    @DeleteMapping(value = "/{user_id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "user_id") Long id){
        LOGGER.info("Calling deleteUser");
        userService.removeUser(id);
        return ResponseEntity.ok().build();
    }
}
