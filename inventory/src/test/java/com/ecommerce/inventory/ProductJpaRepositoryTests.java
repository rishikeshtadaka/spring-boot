package com.ecommerce.inventory;

import com.ecommerce.inventory.domain.Product;
import com.ecommerce.inventory.repository.ProductJpaRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductJpaRepositoryTests {
    @Mock
    EntityManager entityManager;

    @Mock
    ProductJpaRepository productJpaRepository;

    @Mock
    Product product;

    @Test
    void insertProductTest(){
        this.productJpaRepository.Insert(product);
    }
}
