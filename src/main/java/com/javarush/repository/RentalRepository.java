package com.javarush.repository;

import com.javarush.config.SessionCreator;
import com.javarush.entity.Rental;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RentalRepository extends BaseRepository<Rental> {
    public RentalRepository(SessionCreator sessionCreator) {
        super(sessionCreator, Rental.class);
    }

    public Rental getRandomOpenedRental() {
        Session session = getCurrentSession();
        Query<Rental> query = session.createQuery("from Rental r where returnDate is null", Rental.class);
        query.setMaxResults(10);
        List<Rental> rentals = query.list();
        return rentals.isEmpty() ? null : rentals.get((int) (Math.random() * rentals.size()));
    }
}
