package com.javarush.repository;

import com.javarush.config.SessionCreator;
import com.javarush.entity.Customer;

public class CustomerRepository extends BaseRepository<Customer> {
    public CustomerRepository(SessionCreator sessionCreator) {
        super(sessionCreator, Customer.class);
    }
}
