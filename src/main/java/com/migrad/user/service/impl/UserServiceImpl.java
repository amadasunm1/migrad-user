package com.migrad.user.service.impl;

import com.migrad.user.exception.BadRequestException;
import com.migrad.user.model.User;
import com.migrad.user.model.UserRequest;
import com.migrad.user.repository.UserRepository;
import com.migrad.user.service.UserService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<User> userOptional = userRepository.findById(username);

        if(userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new BadRequestException("User not found");
        }
    }

    @Override
    public User createUser(UserRequest userRequest) {
        User user = User.builder()
                .userName(userRequest.getUserName())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .build();

        return userRepository.save(user);
    }

    @Override
    public void updateUser(UserRequest userRequest) {
        userRepository.findById(userRequest.getUserName()).ifPresentOrElse(existingUser -> {
            existingUser.setFirstName(userRequest.getFirstName());
            existingUser.setLastName(userRequest.getLastName());
            userRepository.save(existingUser);
        }, () -> {
            throw new BadRequestException("User not found");
        });
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }
}
