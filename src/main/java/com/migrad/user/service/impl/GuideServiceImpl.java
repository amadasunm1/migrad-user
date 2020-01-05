package com.migrad.user.service.impl;

import com.migrad.user.model.Guide;
import com.migrad.user.model.GuideRequest;
import com.migrad.user.model.User;
import com.migrad.user.repository.GuideRepository;
import com.migrad.user.repository.UserRepository;
import com.migrad.user.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class GuideServiceImpl implements GuideService {

    @Autowired
    private GuideRepository guideRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public Guide findGuide(String username) {
        Optional<User> optionalUser = userRepository.findById(username);

        if ( optionalUser.isPresent() ){
            return guideRepository.findGuideByUser(optionalUser.get().getUserName());
        }

        return null;
    }

    @Override
    @Transactional
    public void createGuide(String username, GuideRequest guideRequest) {

    }

    @Override
    @Transactional
    public void updateGuide(String username, GuideRequest guideRequest) {

    }
}
