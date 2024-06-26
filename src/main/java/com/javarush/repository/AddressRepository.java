package com.javarush.repository;

import com.javarush.config.SessionCreater;
import com.javarush.entity.Address;

public class AddressRepository extends BaseRepository<Address> {
    public AddressRepository(SessionCreater sessionCreater) {
        super(sessionCreater, Address.class);
    }
}
