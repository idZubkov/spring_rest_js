package edu.zubkov.crudapp.services;

import edu.zubkov.crudapp.models.Role;
import edu.zubkov.crudapp.models.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void add(User user);

    void deleteById(long id);

    void update(User user);

    User getById(long id);

    List<User> getAllUsers();

    Set<Role> getAllRoles(List<String> idOfRoles);

    User findByUsername(String username);
}