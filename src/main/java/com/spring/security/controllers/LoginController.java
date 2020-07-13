package com.spring.security.controllers;

import com.spring.security.entity.Users;
import com.spring.security.exception.DuplicateUserFoundException;
import com.spring.security.security.UserContextFactory;
import com.spring.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;

@Controller
public class LoginController {

    @Autowired
    private SecurityService service;

    Logger logger = Logger.getLogger(LoginController.class.getName());

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "plain-login";
    }

    @GetMapping("/signup")
    public String registerUser(Model model){
        model.addAttribute("user",new Users());
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

    @PostMapping("/processUser")
    public String processUser(@ModelAttribute("user") Users user,Model model){
        logger.info("Users : "+user);
        try {
            service.saveUser(user);
            model.addAttribute("message","User create successfully !!!");
            return "plain-login";
        }
        catch (DuplicateUserFoundException e){
            logger.info(e.getMessage());
            return "error-page";
        }

    }
}
