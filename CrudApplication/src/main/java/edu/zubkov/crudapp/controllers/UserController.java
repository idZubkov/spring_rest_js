package edu.zubkov.crudapp.controllers;

import edu.zubkov.crudapp.models.User;
import edu.zubkov.crudapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable(name = "id") long id) {
        return new ModelAndView("update", "user", userService.getById(id));
    }

    @PostMapping("/update/{id}")
    public String editUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute(new User());
        return "create";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/";
    }
}