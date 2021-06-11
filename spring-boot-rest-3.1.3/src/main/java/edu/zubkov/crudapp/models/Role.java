package edu.zubkov.crudapp.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String nameOfRole;

    @Override
    public String getAuthority() {
        return nameOfRole;
    }

    @Override
    public String toString() {
        return nameOfRole;
    }
}