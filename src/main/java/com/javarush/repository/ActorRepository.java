package com.javarush.repository;

import com.javarush.config.SessionCreater;
import com.javarush.entity.Actor;

public class ActorRepository extends BaseRepository<Actor>{
    public ActorRepository(SessionCreater sessionCreater) {
        super(sessionCreater, Actor.class);
    }
}
