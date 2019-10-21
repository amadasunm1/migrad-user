package com.migrad.user.service;

import com.migrad.user.model.User;

public interface UserService {
    User getAllUsers();

    User getUserByUsername();
}
