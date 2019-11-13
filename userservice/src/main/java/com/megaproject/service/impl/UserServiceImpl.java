package com.megaproject.service.impl;

import com.megaproject.dto.UserRequest;
import com.megaproject.entity.User;
import com.megaproject.repository.UserRepository;
import com.megaproject.service.UserService;
import com.sun.jersey.api.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(UserRequest userRequest) {
        return userRepository.save(User.builder()
                .userId(userRequest.getUserId())
                .age(userRequest.getAge())
                .userEmailId(userRequest.getUserEmailId())
                .userName(userRequest.getUserName())
                .build());
    }

    @Override
    public User getUser(Long id) {
        if (!userRepository.existsById(id))
            throw new NotFoundException("User Not Found");
        Optional<User> user = userRepository.findById(id);
        return user.isPresent()?user.get():null;
    }

    @Override
    public void removeUser(Long id) {
        if (!userRepository.existsById(id))
            throw new NotFoundException("User Not Found");
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(UserRequest userRequest) {
        if (!userRepository.existsById(userRequest.getUserId()))
            throw new NotFoundException("User Not Found");

        User userUpdate = userRepository.getOne(userRequest.getUserId());
        userUpdate.setUserName(userRequest.getUserName());
        userUpdate.setAge(userRequest.getAge());
        userUpdate.setUserEmailId(userRequest.getUserEmailId());
        return userRepository.save(userUpdate);
    }
}
