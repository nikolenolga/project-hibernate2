package com.javarush.repository;

import com.javarush.config.SessionCreator;
import com.javarush.entity.Country;

public class CountryRepository extends BaseRepository<Country> {
    public CountryRepository(SessionCreator sessionCreator) {
        super(sessionCreator, Country.class);
    }
}
