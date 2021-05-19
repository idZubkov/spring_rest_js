package edu.zubkov.crudapp.controllers;

import edu.zubkov.crudapp.models.User;
import edu.zubkov.crudapp.services.RoleService;
import edu.zubkov.crudapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin-rest")
public class AdminRestController {

    private final UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> allUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<User> editUser(@RequestBody User user, @PathVariable("id") long id) {
        userService.update(user, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/createNewUser")
    public ResponseEntity<User> create(@RequestBody User user) {
        userService.add(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}