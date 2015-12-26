package com.github.tobilko.dao.factory;

import com.github.tobilko.dao.DAO;

import javax.persistence.EntityManager;

public interface DAOFactory<T> {
    DAO<T> createDAO(EntityManager manager);
}

