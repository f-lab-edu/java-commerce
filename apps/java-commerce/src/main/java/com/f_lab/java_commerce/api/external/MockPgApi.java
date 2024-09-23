package com.f_lab.java_commerce.api.external;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MockPgApi implements PgApi {
    @Override
    public void confirmPayment(String paymentKey, String orderId, BigDecimal amount) {
        System.out.println("MockPgApi.confirmPayment");
    }
}
