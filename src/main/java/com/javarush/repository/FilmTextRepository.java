package com.javarush.repository;

import com.javarush.config.SessionCreator;
import com.javarush.entity.FilmText;

public class FilmTextRepository extends BaseRepository<FilmText> {
    public FilmTextRepository(SessionCreator sessionCreator) {
        super(sessionCreator, FilmText.class);
    }
}
