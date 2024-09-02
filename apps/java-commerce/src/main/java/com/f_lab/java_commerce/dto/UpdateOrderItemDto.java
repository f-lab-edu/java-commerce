package com.f_lab.java_commerce.dto;

import java.math.BigDecimal;

public record UpdateOrderItemDto(
    Long orderItemId,
    BigDecimal orderPrice,
    int quantity
) {
}
