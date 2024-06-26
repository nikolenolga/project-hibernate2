package com.javarush.repository;

import com.javarush.config.SessionCreator;
import com.javarush.entity.Payment;

public class PaymentRepository extends BaseRepository<Payment> {
    public PaymentRepository(SessionCreator sessionCreator) {
        super(sessionCreator, Payment.class);
    }
}
