package com.f_lab.java_commerce.dto;

import com.f_lab.java_commerce.domain.Delivery;
import com.f_lab.java_commerce.domain.OrderStatus;
import com.f_lab.java_commerce.domain.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record UpdateOrderDto(
    Long orderId,
    List<UpdateOrderItemDto> orderItems,
    OrderStatus status,
    BigDecimal orderAmount,
    PaymentMethod paymentMethod,
    String ordererName,
    String ordererPhoneNumber,
    String receiverName,
    String receiverPhoneNumber,
    Delivery delivery
) {
}
