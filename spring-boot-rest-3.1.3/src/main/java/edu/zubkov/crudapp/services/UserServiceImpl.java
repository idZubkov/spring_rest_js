package edu.zubkov.crudapp.services;

import edu.zubkov.crudapp.dao.RoleDAO;
import edu.zubkov.crudapp.dao.UserDAO;
import edu.zubkov.crudapp.models.Role;
import edu.zubkov.crudapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final RoleDAO roleDAO;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void add(User user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setUsername(user.getUsername());
        newUser.setProfession(user.getProfession());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        Set<Role> rolesForUser = new HashSet<>();
        Set<Role> rolesForUser2 = new HashSet<>();

        rolesForUser.add(roleDAO.roleByName("ROLE_ADMIN"));
        rolesForUser.add(roleDAO.roleByName("ROLE_USER"));

        rolesForUser2.add(roleDAO.roleByName("ROLE_USER"));

        for (Role role : user.getRoles()) {
            if (role.getNameOfRole().equals("ROLE_ADMIN")) {
                newUser.setRoles(rolesForUser);
            } else
                newUser.setRoles(rolesForUser2);
        }
        userDAO.add(newUser);
    }


    @Override
    @Transactional
    public void deleteById(long id) {
        userDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void update(User user, long id) {
        User userToUpdate = getById(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setSurname(user.getSurname());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setProfession(user.getProfession());
        userToUpdate.setPassword(passwordEncoder.encode(user.getPassword()));

        Set<Role> rolesForUser = new HashSet<>();
        Set<Role> rolesForUser2 = new HashSet<>();

        rolesForUser.add(roleDAO.roleByName("ROLE_ADMIN"));
        rolesForUser.add(roleDAO.roleByName("ROLE_USER"));

        rolesForUser2.add(roleDAO.roleByName("ROLE_USER"));

        for (Role role : user.getRoles()) {
            if (role.getNameOfRole().equals("ROLE_ADMIN")) {
                userToUpdate.setRoles(rolesForUser);
            } else
                userToUpdate.setRoles(rolesForUser2);
            userDAO.update(userToUpdate);
        }
    }

    @Override
    @Transactional
    public User getById(long id) {
        return userDAO.getById(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDAO.findByUsername(s);
    }
}