package com.migrad.user.controller;

import com.migrad.user.model.Country;
import com.migrad.user.model.Guide;
import com.migrad.user.model.GuideRequest;
import com.migrad.user.model.Occupation;
import com.migrad.user.service.CountryService;
import com.migrad.user.service.GuideService;
import com.migrad.user.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guide-api")
public class GuideController {
    @Autowired
    private GuideService guideService;

    @Autowired
    private OccupationService occupationService;

    @Autowired
    private CountryService countryService;

    @GetMapping("guide/{username}")
    public Guide getGuide(@PathVariable String username) {
        return guideService.findGuide(username);
    }

    @PostMapping("guide/{username}")
    public String createGuide(@PathVariable String username, @RequestBody GuideRequest guideRequest) {
        guideService.createGuide(username, guideRequest);
        return "Guide created!";
    }

    @PutMapping("guide/{username}")
    public String updateGuide(@PathVariable String username, @RequestBody GuideRequest guideRequest) {
        guideService.updateGuide(username, guideRequest);
        return "Guide updated!";
    }

    @GetMapping("occupations")
    public List<Occupation> findAllOccupations() {
        return occupationService.findAll();
    }

    @GetMapping("country")
    public List<Country> findAllCountries() {
        return countryService.findAll();
    }
}
