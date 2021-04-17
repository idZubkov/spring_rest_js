package edu.zubkov.crudapp.dao;

import edu.zubkov.crudapp.models.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> listOfRoles();

    Role roleById(long id);
}
