package com.ecommerce.inventory.repository;

import com.ecommerce.inventory.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductSpringDataJpaRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
