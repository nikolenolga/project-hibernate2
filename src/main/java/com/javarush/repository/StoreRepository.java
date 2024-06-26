package com.javarush.repository;

import com.javarush.config.SessionCreater;
import com.javarush.entity.Store;

public class StoreRepository extends BaseRepository<Store> {
    public StoreRepository(SessionCreater sessionCreater) {
        super(sessionCreater, Store.class);
    }
}
