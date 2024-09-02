package com.f_lab.java_commerce.data;

import com.f_lab.java_commerce.domain.Product;
import com.f_lab.java_commerce.domain.ProductDiscount;
import com.f_lab.java_commerce.domain.ProductDiscountType;
import com.f_lab.java_commerce.domain.ProductStatus;
import net.datafaker.Faker;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProductDummyDataGenerator {
    private static final int PRODUCT_COUNT = 1000;

    public ProductDummyDataGenerator() {
    }

    public List<Product> generate() {
        return IntStream.range(0, PRODUCT_COUNT)
            .mapToObj(i -> createDummyProduct())
            .collect(Collectors.toList());
    }

    private Product createDummyProduct() {
        Faker faker = new Faker();
        return new Product(ProductStatus.ACTIVE,
            faker.commerce().productName(),
            faker.lorem().sentence(),
            BigDecimal.valueOf(faker.number().randomDouble(0, 5000, 10000)),
            BigDecimal.valueOf(faker.number().randomDouble(0, 1000, 3000)),
            faker.number().numberBetween(1, 1000),
            new ProductDiscount(ProductDiscountType.AMOUNT, BigDecimal.valueOf(0.1), 100));
    }

    public static void main(String[] args) {
        ProductDummyDataGenerator generator = new ProductDummyDataGenerator();
        generator.generate();
    }
}
