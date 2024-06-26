package com.javarush.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface Repository<T> {

        Collection<T> getAll();

        Stream<T> getEntities(int offset, int limit);

        int getCountAll();

        T create(T entity);

        void update(T entity);

        void delete(T entity);

        Optional<T> get(Number id);

        T getRandomEntity();

        //Stream<T> find(T pattern);
}
