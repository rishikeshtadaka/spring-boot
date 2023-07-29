package com.ecommerce.inventory.service;

import com.ecommerce.inventory.repository.ProductJdbcRepository;
import com.ecommerce.inventory.domain.Product;
import com.ecommerce.inventory.repository.ProductSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductJdbcRepository productJdbcRepository;

    @Autowired
    private ProductSpringDataJpaRepository productSpringDataJpaRepository;

    public Product GetProductById(Long id){
        return this.productJdbcRepository.GetProductById(id);
    }

    public List<Product> GetAllProducts(){
        return this.productJdbcRepository.GetAllProducts();
    }

    public List<Product> FilterProductsByName(String name){
        return this.productSpringDataJpaRepository.findByName(name);
    }
}
