package edu.zubkov.crudapp.dao;

import edu.zubkov.crudapp.models.User;

import java.util.List;

public interface UserDAO {
    void add(User user);

    void deleteUserById(long id);

    void update(User user);

    void get(long id);

    List<User> getAllUsers();
}
