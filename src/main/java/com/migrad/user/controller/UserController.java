package com.migrad.user.controller;

import com.migrad.user.model.User;
import com.migrad.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/migrad-user-api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello-world")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{username}")
    public User getUserByUsername(@RequestParam String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/users")
    public void deleteUser(@RequestParam String username){
        userService.deleteUser(username);
    }
}
