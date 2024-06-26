package com.javarush.repository;

import com.javarush.config.SessionCreator;
import com.javarush.entity.Staff;

public class StaffRepository extends BaseRepository<Staff> {
    public StaffRepository(SessionCreator sessionCreator) {
        super(sessionCreator, Staff.class);
    }
}
