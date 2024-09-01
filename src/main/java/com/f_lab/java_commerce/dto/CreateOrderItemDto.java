package com.f_lab.java_commerce.dto;

import java.math.BigDecimal;

public record CreateOrderItemDto(
    Long productId,
    BigDecimal orderPrice,
    Integer quantity
) {
}
