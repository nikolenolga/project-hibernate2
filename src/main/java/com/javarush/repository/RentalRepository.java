package com.javarush.repository;

import com.javarush.config.SessionCreater;
import com.javarush.entity.Rental;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RentalRepository extends BaseRepository<Rental>{
    public RentalRepository(SessionCreater sessionCreater) {
        super(sessionCreater, Rental.class);
    }

    public Rental getRandomOpenedRental() {
        Session session = getCurrentSession();
        Query<Rental> query = session.createQuery("from Rental r where returnDate is null", Rental.class);
        query.setMaxResults(10);
        List<Rental> rentals = query.list();
        return rentals.isEmpty() ? null : rentals.get((int) (Math.random() * rentals.size()));
    }
}
