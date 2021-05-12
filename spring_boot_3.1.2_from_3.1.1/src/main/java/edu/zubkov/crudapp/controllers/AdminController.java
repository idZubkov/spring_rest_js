package edu.zubkov.crudapp.controllers;

import edu.zubkov.crudapp.models.Role;
import edu.zubkov.crudapp.models.User;
import edu.zubkov.crudapp.services.RoleService;
import edu.zubkov.crudapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String allUsers(Model model, Principal principal) {
        List<Role> rolez = roleService.listOfRoles();
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("rolez", rolez);
        model.addAttribute("newUser", new User());
        model.addAttribute("user", user);
        return "admin";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@Validated(User.class) @ModelAttribute("user") User user,
                           @RequestParam(value = "authorities", required = false) String roles,
                           @PathVariable("id") long id) {

        Set<Role> roleSet = roleService.getAllRoles(roles);
        user.setRoles(roleSet);;
        userService.update(user, id);
        return "redirect:/admin";
    }

    @PostMapping("/createNewUser")
    public String create(@Validated(User.class) @ModelAttribute("user") User user,
                         @RequestParam("authorities") String roles) {
        Set<Role> setOfRoles = roleService.getAllRoles(roles);
        user.setRoles(setOfRoles);
        userService.add(user);
        return "redirect:/admin";
    }

    @PostMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }
}