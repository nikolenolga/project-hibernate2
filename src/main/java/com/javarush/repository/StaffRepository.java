package com.javarush.repository;

import com.javarush.config.SessionCreater;
import com.javarush.entity.Staff;

public class StaffRepository extends BaseRepository<Staff>{
    public StaffRepository(SessionCreater sessionCreater) {
        super(sessionCreater, Staff.class);
    }
}
