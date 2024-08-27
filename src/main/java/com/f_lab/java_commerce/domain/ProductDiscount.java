package com.f_lab.java_commerce.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.math.BigDecimal;

@Embeddable
@Getter
public class ProductDiscount {
    private ProductDiscountType type;
    private BigDecimal discountRate;
    private int discountAmount;

    protected ProductDiscount() {
    }

    public ProductDiscount(ProductDiscountType type, BigDecimal discountRate, int discountAmount) {
        this.type = type;
        this.discountRate = discountRate;
        this.discountAmount = discountAmount;
    }
}
