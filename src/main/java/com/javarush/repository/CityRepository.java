package com.javarush.repository;

import com.javarush.config.SessionCreator;
import com.javarush.entity.City;

public class CityRepository extends BaseRepository<City> {
    public CityRepository(SessionCreator sessionCreator) {
        super(sessionCreator, City.class);
    }
}
