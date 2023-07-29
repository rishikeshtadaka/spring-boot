package com.ecommerce.inventory.repository;

import com.ecommerce.inventory.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ProductJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String insertProduct=
            """
                insert into product(id,name)
                values(1,'Laptop');
            """;
    private static String selectProduct= """
            select * from product where id=?;
            """;
    private static String selectAllProducts= """
            select * from product;
            """;
    public void insert(){
        this.jdbcTemplate.update(insertProduct);
    }

    public Product GetProductById(Long id){
        return this.jdbcTemplate.queryForObject(
                selectProduct, new BeanPropertyRowMapper<>(Product.class),id
        );
    }

    public List<Product> GetAllProducts(){
        //TODO: Make following logic Generic
        List<Map<String, Object>> list=this.jdbcTemplate.queryForList(selectAllProducts);
        List<Product> products=new ArrayList<>();
        for (Map<String, Object> m : list) {
            Product p=new Product((Long)m.get("id"),(String)m.get("name"));
            products.add(p);
        }
        return products;
    }
}
