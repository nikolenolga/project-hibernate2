package com.javarush.repository;

import com.javarush.config.SessionCreator;
import com.javarush.entity.Language;

public class LanguageRepository extends BaseRepository<Language> {
    public LanguageRepository(SessionCreator sessionCreator) {
        super(sessionCreator, Language.class);
    }
}
