package com.f_lab.java_commerce.dto;

import java.math.BigDecimal;
import java.util.List;

public record CreateOrderDto(
    List<CreateOrderItemDto> orderItems,
    BigDecimal orderAmount
) {
}
