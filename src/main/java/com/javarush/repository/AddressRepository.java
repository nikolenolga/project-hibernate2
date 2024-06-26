package com.javarush.repository;

import com.javarush.config.SessionCreator;
import com.javarush.entity.Address;

public class AddressRepository extends BaseRepository<Address> {
    public AddressRepository(SessionCreator sessionCreator) {
        super(sessionCreator, Address.class);
    }
}
