package com.migrad.user.service;

import com.migrad.user.model.Guide;
import com.migrad.user.model.GuideRequest;

public interface GuideService {
    Guide findGuide(String username);

    void createGuide(String username, GuideRequest guideRequest);

    void updateGuide(String username, GuideRequest guideRequest);
}
