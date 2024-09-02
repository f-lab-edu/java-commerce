package com.f_lab.java_commerce.data;

import com.f_lab.java_commerce.domain.Product;
import com.f_lab.java_commerce.repository.ProductRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductDummyDataGeneratorTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Disabled
    public void generate() {
        ProductDummyDataGenerator generator = new ProductDummyDataGenerator();
        List<Product> products = generator.generate();

        productRepository.saveAll(products);
    }
}
