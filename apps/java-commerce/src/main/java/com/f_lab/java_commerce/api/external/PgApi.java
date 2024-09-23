package com.f_lab.java_commerce.api.external;

import java.math.BigDecimal;

public interface PgApi {
    void confirmPayment(String paymentKey, String orderId, BigDecimal amount);
}
