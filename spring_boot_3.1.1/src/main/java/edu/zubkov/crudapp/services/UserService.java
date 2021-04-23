package edu.zubkov.crudapp.services;

import edu.zubkov.crudapp.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void add(User user);

    void deleteById(long id);

    void update(User user);

    User getById(long id);

    List<User> getAllUsers();

    User findByUsername(String username);
}