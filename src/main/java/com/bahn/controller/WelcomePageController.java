package com.bahn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomePageController {

    @RequestMapping("/welcome")
    public String showWelcomePage(){
        return "Yay!";
    }
}
