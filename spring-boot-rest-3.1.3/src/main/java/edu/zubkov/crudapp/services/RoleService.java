package edu.zubkov.crudapp.services;

import edu.zubkov.crudapp.models.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    Set<Role> setOfRoles(List<Role> listOfRoles);
}