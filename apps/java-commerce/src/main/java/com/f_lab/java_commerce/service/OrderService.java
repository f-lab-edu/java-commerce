package com.f_lab.java_commerce.service;

import com.f_lab.java_commerce.domain.Order;
import com.f_lab.java_commerce.domain.OrderItem;
import com.f_lab.java_commerce.domain.Product;
import com.f_lab.java_commerce.dto.CreateOrderDto;
import com.f_lab.java_commerce.dto.CreateOrderItemDto;
import com.f_lab.java_commerce.repository.OrderRepository;
import com.f_lab.java_commerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Long createOrder(CreateOrderDto dto) {
        Set<Long> productIds = extractProductIds(dto);
        Map<Long, Product> productMap = getProductMapByIds(productIds);

        validateProductIds(productIds, productMap);

        List<OrderItem> orderItems = createOrderItems(dto, productMap);

        return orderRepository.save(new Order(orderItems, dto.orderAmount()));
    }

    private List<OrderItem> createOrderItems(CreateOrderDto dto, Map<Long, Product> productMap) {
        return dto.orderItems().stream()
            .map(orderItemDto -> new OrderItem(
                productMap.get(orderItemDto.productId()),
                orderItemDto.orderPrice(),
                orderItemDto.quantity()
            ))
            .toList();
    }

    private void validateProductIds(Set<Long> productIds, Map<Long, Product> productMap) {
        if (productIds.size() != productMap.size()) {
            throw new IllegalArgumentException("Invalid product id");
        }
    }

    private Map<Long, Product> getProductMapByIds(Set<Long> productIds) {
        return productRepository.findAllById(productIds)
            .stream()
            .collect(Collectors.toMap(Product::getId, Function.identity()));
    }

    private Set<Long> extractProductIds(CreateOrderDto dto) {
        return dto.orderItems().stream()
            .map(CreateOrderItemDto::productId)
            .collect(Collectors.toSet());
    }
}
