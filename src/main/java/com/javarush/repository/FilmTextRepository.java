package com.javarush.repository;

import com.javarush.config.SessionCreater;
import com.javarush.entity.FilmText;

public class FilmTextRepository extends BaseRepository<FilmText> {
    public FilmTextRepository(SessionCreater sessionCreater) {
        super(sessionCreater, FilmText.class);
    }
}
