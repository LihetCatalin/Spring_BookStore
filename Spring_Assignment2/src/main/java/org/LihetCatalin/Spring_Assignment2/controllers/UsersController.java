package org.LihetCatalin.Spring_Assignment2.controllers;

import jakarta.validation.Valid;
import org.LihetCatalin.Spring_Assignment2.models.Role;
import org.LihetCatalin.Spring_Assignment2.models.User;
import org.LihetCatalin.Spring_Assignment2.models.UserDTO.UserDTO;
import org.LihetCatalin.Spring_Assignment2.models.auxModels.UserAuxData;
import org.LihetCatalin.Spring_Assignment2.service.RoleService;
import org.LihetCatalin.Spring_Assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("users")
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String displayAllUsers(Model model){
        model.addAttribute("title", "All Users");
        List<UserDTO> dtos = new ArrayList<>();
        List<User> users = userService.findAll();
        for(User user:users){
            UserDTO dto = new UserDTO();
            dto.setUser(user);
            dtos.add(dto);
        }
        model.addAttribute("users", dtos);
        return "users/index";
    }

    @GetMapping("create")
    public String displayCreateUserForm(Model model){
        model.addAttribute("title", "Create User");
        model.addAttribute("user", new User());
        return "users/create";
    }

    @PostMapping("create")
    public String processCreateUserForm(@ModelAttribute @Valid User newUser,
                                        Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Create User");
            return "users/create";
        }

        newUser.getRoles().add(roleService.findByName("REGULAR_USER"));
        newUser.setPassword(userService.hashPassword(newUser.getPassword()));
        userService.saveUser(newUser);
        return "redirect:/users";
    }

    @GetMapping("update")
    public String displayUpdateUserForm(Model model){
        model.addAttribute("title", "Update User");
        model.addAttribute(new User());
        model.addAttribute("auxData", new UserAuxData());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("roles", roleService.findAll());
        return "users/update";
    }

    @PostMapping("update")
    public String processUpdateUserForm(@ModelAttribute UserAuxData userAuxData,
                                        @ModelAttribute @Valid User user,
                                        Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Update User");
            return "users/update";
        }else if(!userService.existsById(userAuxData.getIdToUpdate())){
            model.addAttribute("errMsg"
                    , "Book with this Id does not exist!");
            return "users/update";
        }
        User userToUpdate = userService.findById(userAuxData.getIdToUpdate()).get();
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());
        //+ add new role if not exists
        Role roleToAdd = roleService.findById(userAuxData.getIdRole());
        if(!userToUpdate.getRoles().contains(roleToAdd))
            userToUpdate.getRoles().add(roleToAdd);
        userService.saveUser(userToUpdate);
        return "redirect:/users";
    }

    @GetMapping("delete")
    public String displayDeleteUserForm(Model model){
        model.addAttribute("title", "Delete Users");
        model.addAttribute("users", userService.findAll());
        return "users/delete";
    }

    @PostMapping("delete")
    public String processDeleteUserForm(@RequestParam(required = false) int[] userIds){
        if(userIds != null){
            for (int id:userIds){
                userService.removeById(id);
            }
        }
        return "redirect:/users";
    }
}
