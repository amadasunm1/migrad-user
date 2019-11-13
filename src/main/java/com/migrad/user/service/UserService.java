package com.migrad.user.service;

import com.migrad.user.model.User;
import com.migrad.user.model.UserRequest;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserByUsername(String username);

    User createUser(UserRequest userRequest);

    void updateUser(UserRequest userRequest);

    void deleteUser(String username);
}
