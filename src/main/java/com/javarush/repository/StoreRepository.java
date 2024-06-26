package com.javarush.repository;

import com.javarush.config.SessionCreator;
import com.javarush.entity.Store;

public class StoreRepository extends BaseRepository<Store> {
    public StoreRepository(SessionCreator sessionCreator) {
        super(sessionCreator, Store.class);
    }
}
