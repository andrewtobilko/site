package com.github.tobilko.dao;

import java.util.Collection;

public interface DAO<T> {
    void add(T element);

    void set(T oldValue, T newValue);

    T get();

    Collection<T> getAll();

    default void remove(T element) {
        throw new UnsupportedOperationException("remove");
    }
}