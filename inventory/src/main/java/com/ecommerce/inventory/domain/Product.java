package com.ecommerce.inventory.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "product")
@AllArgsConstructor
public class Product {
    public Product(){}
    @Id
    private Long id;
    @Column(name="name")
    private String name;
}
