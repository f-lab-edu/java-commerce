package com.f_lab.java_commerce.domain;

import com.f_lab.java_commerce.dto.UpdateOrderDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Order {

    protected Order() {
    }

    public Order(List<OrderItem> orderItems, BigDecimal orderAmount) {
        orderItems.forEach(this::addOrderItem);
        this.orderAmount = orderAmount;
        this.status = OrderStatus.PAYMENT_PENDING;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private final List<OrderItem> orderItems = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    private BigDecimal orderAmount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private LocalDateTime paidAt;

    private String ordererName;
    private String ordererPhoneNumber;
    private String receiverName;
    private String receiverPhoneNumber;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void updateOrderBeforePayment(UpdateOrderDto dto) {
        this.status = dto.status();
        this.orderAmount = dto.orderAmount();
        this.paymentMethod = dto.paymentMethod();
        this.ordererName = dto.ordererName();
        this.ordererPhoneNumber = dto.ordererPhoneNumber();
        this.receiverName = dto.receiverName();
        this.receiverPhoneNumber = dto.receiverPhoneNumber();
        this.delivery = dto.delivery();
    }
}
