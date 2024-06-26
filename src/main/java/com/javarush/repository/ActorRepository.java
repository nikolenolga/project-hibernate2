package com.javarush.repository;

import com.javarush.config.SessionCreator;
import com.javarush.entity.Actor;

public class ActorRepository extends BaseRepository<Actor> {
    public ActorRepository(SessionCreator sessionCreator) {
        super(sessionCreator, Actor.class);
    }
}
