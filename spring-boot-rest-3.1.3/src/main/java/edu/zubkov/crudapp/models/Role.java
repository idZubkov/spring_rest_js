package edu.zubkov.crudapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @JsonIgnore
    private String nameOfRole;

//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users;

    public Role() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOfRole() {
        return nameOfRole;
    }

    public void setNameOfRole(String nameOfRole) {
        this.nameOfRole = nameOfRole;
    }

//    public Set<User> getUsers() {
//        return users;
//    }

//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }

    @Override
    public String getAuthority() {
        return nameOfRole;
    }

    @Override
    public String toString() {
        return nameOfRole;
    }
}
