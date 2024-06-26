package com.javarush.repository;

import com.javarush.config.SessionCreator;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

@AllArgsConstructor
public abstract class BaseRepository<T> implements Repository<T> {
    private SessionCreator sessionCreator;
    private final Class<T> entityClass;

    @Override
    public Collection<T> getAll() {
        Session session = sessionCreator.getSession();
        Query<T> query = session.createQuery("SELECT entity FROM %s entity".formatted(entityClass.getName()), entityClass);
        return query.getResultList();
    }

    public Stream<T> getEntities(int offset, int limit) {
        Session session = sessionCreator.getSession();
        Query<T> query = session.createQuery("SELECT entity FROM %s entity".formatted(entityClass.getName()), entityClass);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList().stream();
    }

    public int getCountAll() {
        Session session = sessionCreator.getSession();
        Query<Long> query = session.createQuery("SELECT count(entity) FROM %s entity".formatted(entityClass.getName()), Long.class);
        return query.uniqueResult().intValue();
    }

    @Override
    public void create(T entity) {
        Session session = sessionCreator.getSession();
        session.saveOrUpdate(entity);
    }

    @Override
    public void update(T entity) {
        Session session = sessionCreator.getSession();
        session.merge(entity);
    }

    @Override
    public void delete(T entity) {
        Session session = sessionCreator.getSession();
        session.remove(entity);
    }

    @Override
    public Optional<T> get(Number id) {
        System.out.println(id);
        Session session = sessionCreator.getSession();
        T entity = session.get(entityClass, id);
        System.out.println(entity);
        return Optional.of(entity);
    }

    @Override
    public T getRandomEntity() {
        int amount = getCountAll();
        int entityNumber = (int) (Math.random() * amount);
        return getEntities(entityNumber, 1)
                .findFirst()
                .orElse(null);
    }

    public Session getCurrentSession() {
        return sessionCreator.getSession();
    }
}
