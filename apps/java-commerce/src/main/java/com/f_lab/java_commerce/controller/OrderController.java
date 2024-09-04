package com.f_lab.java_commerce.controller;

import com.f_lab.java_commerce.dto.CreateOrderDto;
import com.f_lab.java_commerce.dto.CreateResponseDto;
import com.f_lab.java_commerce.dto.UpdateOrderDto;
import com.f_lab.java_commerce.dto.UpdateResponseDto;
import com.f_lab.java_commerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orders")
    public CreateResponseDto createOrder(@RequestBody CreateOrderDto createOrderDto) {
        Long orderId = orderService.createOrder(createOrderDto);

        return new CreateResponseDto(orderId.toString());
    }

    @PatchMapping("/orders/{orderId}")
    public UpdateResponseDto updateOrderBeforePayment(@RequestBody UpdateOrderDto updateOrderDto, @PathVariable Long orderId) {
        orderService.updateOrderBeforePayment(orderId, updateOrderDto);

        return new UpdateResponseDto(orderId.toString());
    }
}
