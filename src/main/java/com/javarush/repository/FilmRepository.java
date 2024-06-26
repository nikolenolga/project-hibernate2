package com.javarush.repository;

import com.javarush.config.SessionCreator;
import com.javarush.entity.Film;

public class FilmRepository extends BaseRepository<Film> {
    public FilmRepository(SessionCreator sessionCreator) {
        super(sessionCreator, Film.class);
    }
}
