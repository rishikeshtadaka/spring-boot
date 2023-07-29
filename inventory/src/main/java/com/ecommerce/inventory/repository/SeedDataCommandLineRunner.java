package com.ecommerce.inventory.repository;

import com.ecommerce.inventory.domain.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class SeedDataCommandLineRunner implements CommandLineRunner {
    @Autowired
    private ProductJdbcRepository productJdbcRepository;

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        this.productJdbcRepository.insert();
        this.productJpaRepository.Insert(new Product(101L,"iPhone"));
    }
}
