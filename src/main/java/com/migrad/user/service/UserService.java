package com.migrad.user.service;

import com.migrad.user.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserByUsername(String username);

    User createUser(User user);

    void updateUser(User user);

    void deleteUser(String username);
}
