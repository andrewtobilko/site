package com.github.tobilko.dao.factory;

import com.github.tobilko.dao.DAO;
import com.github.tobilko.dao.UserDAO;
import com.github.tobilko.entity.User;

import javax.persistence.EntityManager;

public class UserDAOFactory implements DAOFactory<User> {
    @Override
    public DAO<User> createDAO(EntityManager manager) {
        return new UserDAO(manager);
    }
}
