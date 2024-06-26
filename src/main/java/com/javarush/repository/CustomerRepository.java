package com.javarush.repository;

import com.javarush.config.SessionCreater;
import com.javarush.entity.Customer;

public class CustomerRepository extends BaseRepository<Customer> {
    public CustomerRepository(SessionCreater sessionCreater) {
        super(sessionCreater, Customer.class);
    }
}
