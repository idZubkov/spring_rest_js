package edu.zubkov.crudapp.dao;

import edu.zubkov.crudapp.models.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> listOfRoles() {
        return entityManager.createQuery("FROM Role").getResultList();
    }

    @Override
    public Role roleById(long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Set<Role> setOfRoles(String roles) {
        Query fromRole = entityManager.createQuery("FROM Role", Role.class);
        Set<Role> roleSet = new HashSet<>(fromRole.getResultList());
        return roleSet;
    }

    @Override
    public Role roleByName(String nameOfRole) {
        TypedQuery<Role> query = entityManager.createQuery("select role from Role role where role.name = :nameOfRole", Role.class);
        query.setParameter("nameOfRole", nameOfRole);
        Role role = query.getSingleResult();
        return role;
    }
}