package com.javarush.repository;

import com.javarush.config.SessionCreator;
import com.javarush.entity.Category;

public class CategoryRepository extends BaseRepository<Category> {
    public CategoryRepository(SessionCreator sessionCreator) {
        super(sessionCreator, Category.class);
    }
}
