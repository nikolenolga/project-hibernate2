package com.javarush.repository;

import com.javarush.config.SessionCreater;
import com.javarush.entity.Country;

public class CountryRepository extends BaseRepository<Country> {
    public CountryRepository(SessionCreater sessionCreater) {
        super(sessionCreater, Country.class);
    }
}
