package com.f_lab.java_commerce.domain;

import com.f_lab.java_commerce.exception.NotEnoughStockException;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
@Table(name = "products")
@Getter
public class Product {

    protected Product() {

    }

    public Product(
        ProductStatus status,
        String title,
        String description,
        BigDecimal retailPrice,
        BigDecimal supplyPrice,
        int stockQuantity,
        ProductDiscount discount
    ) {
        this.status = status;
        this.title = title;
        this.description = description;
        this.retailPrice = retailPrice;
        this.supplyPrice = supplyPrice;
        this.stockQuantity = stockQuantity;
        this.discount = discount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    private String title;
    private String description;
    private BigDecimal retailPrice;
    private BigDecimal supplyPrice;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @Embedded
    private ProductDiscount discount;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        var now = LocalDateTime.now(ZoneOffset.UTC);
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now(ZoneOffset.UTC);
    }

    public void reduceStock(int quantity) {
        if (stockQuantity < quantity) {
            throw new NotEnoughStockException();
        }
        stockQuantity -= quantity;
    }
}
