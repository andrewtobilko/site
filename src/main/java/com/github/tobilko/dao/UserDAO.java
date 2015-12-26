package com.github.tobilko.dao;

import com.github.tobilko.entity.User;

import javax.persistence.EntityManager;
import java.util.Collection;

public class UserDAO implements DAO<User> {

    private EntityManager manager;

    public UserDAO(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(User element) {
        throw new UnsupportedOperationException("add");
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
    public Collection<User> getAll() {
        // TODO: 26/12/2015 it will be replaced by .class
        return manager.createNamedQuery("User.findAll").getResultList();
    }
}