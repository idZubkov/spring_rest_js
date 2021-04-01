package edu.zubkov.crudapp.controllers;

import edu.zubkov.crudapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String allUsers(Model model) {
        model.addAttribute("user", userService.getAllUsers());
        return "users";
    }

    @PatchMapping("/edit")
    public String edit() {
        return "edit";
    }

    @PostMapping("/new")
    public String addUser() {
        return "newUser";
    }
}
