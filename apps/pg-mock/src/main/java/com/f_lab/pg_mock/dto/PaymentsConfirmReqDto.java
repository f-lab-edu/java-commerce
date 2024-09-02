package com.f_lab.pg_mock.dto;

import java.math.BigDecimal;

public record PaymentsConfirmReqDto(
    String paymentKey,
    String orderId,
    BigDecimal amount
) {
}
