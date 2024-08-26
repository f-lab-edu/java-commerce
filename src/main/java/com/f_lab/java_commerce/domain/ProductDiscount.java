package com.f_lab.java_commerce.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class ProductDiscount {
    private ProductDiscountType type;
    private double discountRate;
    private int discountAmount;

    protected ProductDiscount() {
    }

    public ProductDiscount(ProductDiscountType type, double discountRate, int discountAmount) {
        this.type = type;
        this.discountRate = discountRate;
        this.discountAmount = discountAmount;
    }
}
