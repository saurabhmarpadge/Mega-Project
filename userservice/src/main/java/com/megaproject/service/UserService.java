package com.megaproject.service;

import com.megaproject.dto.UserRequest;
import com.megaproject.entity.User;

import java.util.List;

public interface UserService {

    public User addUser(UserRequest userRequest);

    public List<User> getUsers();

    public User getUser(Long id);

    public void removeUser(Long id);

    public User updateUser(UserRequest userRequest);

}
