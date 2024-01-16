package org.LihetCatalin.Spring_Assignment2.controllers;

import jakarta.validation.Valid;
import org.LihetCatalin.Spring_Assignment2.models.User;
import org.LihetCatalin.Spring_Assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String displayHomePage(){
        return "home";
    }

    @GetMapping("login")
    public String displayLoginPage(Model model){
        model.addAttribute(new User());
        return "login";
    }

    @PostMapping("login")
    public String processLoginPage(@ModelAttribute User user,
                                   Model model){
        User loginUser = userService.login(user.getUsername(), user.getPassword());
        if(loginUser == null){
            model.addAttribute(new User());
            model.addAttribute("errMsg", "Incorrect username or password");
            return "login";
        }
        switch (loginUser.getRoles().get(0).getName()) {
            case "ADMIN":
                return "admin";
            case "REGULAR_USER":
                return "redirect:/books";
            default:
                return "redirect:/";
        }

    }

    @GetMapping("register")
    public String displayRegisterPage(Model model){
        model.addAttribute(new User());
        return "register";
    }

    @PostMapping("register")
    public String processRegisterPage(@ModelAttribute @Valid User user,
                                      Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute(new User());
            return "register";
        }

        if(!userService.register(user.getUsername(), user.getPassword())){
            model.addAttribute(new User());
            model.addAttribute("errMsg", "This user already exists!");
            return "register";
        }
        return "home";
    }
}
