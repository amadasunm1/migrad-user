package com.migrad.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class ProxyController {
    @GetMapping("/community-api-swagger")
    public ModelAndView redirectToSwagger(){
        return new ModelAndView("redirect:/swagger-ui.html");
    }
}
