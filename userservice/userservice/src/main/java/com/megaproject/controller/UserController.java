package com.megaproject.controller;

import com.megaproject.dto.UserRequest;
import com.megaproject.entity.User;
import com.megaproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-service/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public User saveUser(@RequestBody UserRequest userRequest){
        return userService.saveUser(userRequest);
    }

    @PutMapping
    public User updateUser(@RequestBody UserRequest userRequest){
        return userService.updateUser(userRequest);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
