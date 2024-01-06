package org.LihetCatalin.Spring_Assignment2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UsersController {

    @GetMapping
    public String displayAllUsers(Model model){
        model.addAttribute("title", "All Users");
        return "users/index";
    }

    @GetMapping("create")
    public String displayCreateUserForm(Model model){
        model.addAttribute("title", "Create User");
        return "users/create";
    }

    @GetMapping("update")
    public String displayUpdateUserForm(Model model){
        model.addAttribute("title", "Update User");
        return "users/update";
    }

    @GetMapping("delete")
    public String displayDeleteUserForm(Model model){
        model.addAttribute("title", "Delete Users");
        return "users/delete";
    }
}
