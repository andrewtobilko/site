package com.github.tobilko.dao;

import com.github.tobilko.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Collection;

public class UserDAO implements DAO<User> {

    private EntityManager manager;

    public UserDAO(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(User user) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(user);
        transaction.commit();
    }

    @Override
    public void set(User oldValue, User newValue) {
        throw new UnsupportedOperationException("set");
    }

    @Override
    public User get() {
        throw new UnsupportedOperationException("get");
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<User> getAll() {
        return manager.createNamedQuery("User.findAll").getResultList();
    }
}