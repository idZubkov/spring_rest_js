package edu.zubkov.crudapp.dao;

import edu.zubkov.crudapp.models.User;

import java.util.List;

public interface UserDAO {
    void add(User user);

    void deleteById(long id);

    void update(User user);

    User getById(long id);

    List<User> getAllUsers();
}