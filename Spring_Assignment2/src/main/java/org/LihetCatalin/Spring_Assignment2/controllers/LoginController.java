package org.LihetCatalin.Spring_Assignment2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping
    public String loginPage(){
        return "login";
    }
}
