package com.javarush.repository;

import com.javarush.config.SessionCreater;
import com.javarush.entity.Payment;

public class PaymentRepository extends BaseRepository<Payment>{
    public PaymentRepository(SessionCreater sessionCreater) {
        super(sessionCreater, Payment.class);
    }
}
