package com.f_lab.java_commerce.controller;

import com.f_lab.java_commerce.dto.CreateOrderDto;
import com.f_lab.java_commerce.dto.CreateResponseDto;
import com.f_lab.java_commerce.service.OrderService;
import lombok.RequiredArgsConstructor;
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
}
