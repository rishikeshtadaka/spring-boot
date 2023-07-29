package com.ecommerce.productservices.controllers;

import com.ecommerce.productservices.common.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {

    @Autowired
    private Configuration configuration;
    @GetMapping("/products")
    public String getProducts(){
        return "Product 1";
    }

    @GetMapping("configurations")
    public Configuration getConfigurations(){
        return this.configuration;
    }


}
