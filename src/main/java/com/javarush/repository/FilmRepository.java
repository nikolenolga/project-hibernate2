package com.javarush.repository;

import com.javarush.config.SessionCreater;
import com.javarush.entity.Film;

public class FilmRepository extends BaseRepository<Film> {
    public FilmRepository(SessionCreater sessionCreater) {
        super(sessionCreater, Film.class);
    }
}
