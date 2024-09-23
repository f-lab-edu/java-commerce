package com.f_lab.java_commerce.service;

import com.f_lab.java_commerce.api.external.PgApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final OrderService orderService;
    private final PgApi pgApi;

    public void confirmPayment(String paymentKey, String orderId, BigDecimal amount) {
        validatePayment();
        pgApi.confirmPayment(paymentKey, orderId, amount);
    }

    private void validatePayment() {
        // Payment validation logic
    }
}
