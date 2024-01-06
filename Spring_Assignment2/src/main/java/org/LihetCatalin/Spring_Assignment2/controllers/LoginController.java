package org.LihetCatalin.Spring_Assignment2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

    @GetMapping
    public String displayLoginPage(){
        return "login";
    }
}
