package edu.zubkov.crudapp.services;

import edu.zubkov.crudapp.models.Role;

import java.util.List;

public interface RoleService {

    List<Role> listOfRoles();

    Role roleById(long id);
}
