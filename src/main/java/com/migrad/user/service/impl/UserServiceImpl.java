package com.migrad.user.service.impl;

import com.migrad.user.model.User;
import com.migrad.user.repository.UserRepository;
import com.migrad.user.service.UserService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return IterableUtils.toList(userRepository.findAll());
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findById(username).get();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        User existingUser = this.getUserByUsername(user.getUserName());
        if(existingUser != null) {
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("user to update does not exist");
        }
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }
}
