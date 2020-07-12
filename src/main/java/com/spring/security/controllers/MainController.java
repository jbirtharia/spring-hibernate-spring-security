package com.spring.security.controllers;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private Logger logger = Logger.getLogger(MainController.class);

    @GetMapping("/")
    public String home(){
        return "home";
    }

}
