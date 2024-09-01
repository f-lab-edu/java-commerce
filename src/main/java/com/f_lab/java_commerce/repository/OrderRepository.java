package com.f_lab.java_commerce.repository;

import com.f_lab.java_commerce.domain.Order;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public Long save(Order order) {
        em.persist(order);

        return order.getId();
    }
}
