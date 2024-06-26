package com.javarush.repository;

import com.javarush.config.SessionCreater;
import com.javarush.entity.City;

public class CityRepository extends BaseRepository<City> {
    public CityRepository(SessionCreater sessionCreater) {
        super(sessionCreater, City.class);
    }
}
