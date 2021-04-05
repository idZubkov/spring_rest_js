package edu.zubkov.crudapp.services;

import edu.zubkov.crudapp.dao.UserDAO;
import edu.zubkov.crudapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void deleteById(long id) {
        userDAO.deleteById(id);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public User getById(long id) {
        return userDAO.getById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}