package edu.zubkov.crudapp.dao;

import edu.zubkov.crudapp.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOHibernateImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteById(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("FROM User");
        return query.getResultList();
    }
}