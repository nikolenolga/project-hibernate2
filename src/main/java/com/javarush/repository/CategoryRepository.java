package com.javarush.repository;

import com.javarush.config.SessionCreater;
import com.javarush.entity.Category;

public class CategoryRepository extends BaseRepository<Category> {
    public CategoryRepository(SessionCreater sessionCreater) {
        super(sessionCreater, Category.class);
    }
}
