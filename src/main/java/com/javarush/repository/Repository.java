package com.javarush.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public interface Repository<T> {

    Collection<T> getAll();

    Stream<T> getEntities(int offset, int limit);

    int getCountAll();

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    Optional<T> get(Number id);

    T getRandomEntity();
}
