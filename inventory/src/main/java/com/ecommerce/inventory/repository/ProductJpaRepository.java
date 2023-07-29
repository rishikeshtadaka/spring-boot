package com.ecommerce.inventory.repository;

import com.ecommerce.inventory.domain.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProductJpaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void Insert(Product product){
        this.entityManager.merge(product);
    }
}
