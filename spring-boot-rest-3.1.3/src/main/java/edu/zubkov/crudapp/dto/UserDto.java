package edu.zubkov.crudapp.dto;

import edu.zubkov.crudapp.models.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private long id;
    private String name;
    private String surname;
    private String profession;
    private String username;
    private String password;
    private List<Role> roles;
}