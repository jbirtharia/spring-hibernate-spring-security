package com.spring.security.controllers;

import com.spring.security.security.UserContextFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class LoginController {

    Logger logger = Logger.getLogger(LoginController.class.getName());

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "plain-login";
    }

    @GetMapping("/signup")
    public String registerUser(){
        return "plain-signup";
    }

    @GetMapping("/managers")
    public String showManagers(){
        logger.info("Usercontext for manager: "+ UserContextFactory.getUserContext());
        return "managers";
    }

    @GetMapping("/admin")
    public String showAdmin(){
        logger.info("Usercontext for admin : "+ UserContextFactory.getUserContext());
        return "admin";
    }
}
