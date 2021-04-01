package edu.zubkov.crudapp.services;

import edu.zubkov.crudapp.models.User;

import java.util.List;

public interface UserService {
    void add(User user);

    void deleteUserById(long id);

    void update(User user);

    void get(long id);

    List<User> getAllUsers();
}
