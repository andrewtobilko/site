package com.tobilko.site.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class DAO<E> {

    private EntityManager manager;
    private EntityTransaction transaction;
    private Class<E> type;

    public DAO(EntityManager manager, Class<E> type) {
        this.manager = manager;
        this.type = type;
        this.transaction = manager.getTransaction();
    }

    @SuppressWarnings("unchecked")
    public List<E> findAll() {
        return (List<E>) manager.createNamedQuery(type.getSimpleName()+".findAll").getResultList();
    }

    public void add(E user) {
        transaction.begin();
        manager.persist(user);
        transaction.commit();
    }
}
