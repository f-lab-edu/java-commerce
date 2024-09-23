package com.f_lab.java_commerce.dto;

import java.math.BigDecimal;

public record ConfirmPaymentReqDto(
    String paymentKey,
    String orderId,
    BigDecimal amount
) {
}
