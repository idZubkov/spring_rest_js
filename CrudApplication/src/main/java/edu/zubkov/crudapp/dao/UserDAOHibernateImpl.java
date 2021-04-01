package edu.zubkov.crudapp.dao;

import edu.zubkov.crudapp.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOHibernateImpl implements UserDAO {

    @Override
    public void add(User user) {

    }

    @Override
    public void deleteUserById(long id) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void get(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
