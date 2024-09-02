package com.f_lab.java_commerce.repository;

import com.f_lab.java_commerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
