package com.migrad.user.controller;

import com.migrad.user.model.User;
import com.migrad.user.model.UserRequest;
import com.migrad.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody UserRequest userRequest) {
        userService.updateUser(userRequest);
    }

    @DeleteMapping("/users/{username}")
    public void deleteUser(@PathVariable String username){
        userService.deleteUser(username);
    }
}
