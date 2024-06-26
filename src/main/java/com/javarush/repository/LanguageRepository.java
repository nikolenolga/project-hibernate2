package com.javarush.repository;

import com.javarush.config.SessionCreater;
import com.javarush.entity.Language;

public class LanguageRepository extends BaseRepository<Language>{
    public LanguageRepository(SessionCreater sessionCreater) {
        super(sessionCreater, Language.class);
    }
}
