package com.ecommerce.inventory;

import com.ecommerce.inventory.model.ProductModel;
import com.ecommerce.inventory.domain.Product;
import com.ecommerce.inventory.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("products")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(this.productService.GetAllProducts());
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        if(id==0)
            throw new RuntimeException("Product not found");

        return ResponseEntity.ok(this.productService.GetProductById(id));
    }

    @GetMapping("products-filter/{name}")
    public ResponseEntity<List<Product>> getProductById(@PathVariable String name){
        return ResponseEntity.ok(this.productService.FilterProductsByName(name));
    }

    @PostMapping("products")
    public ResponseEntity<ProductModel> createProduct(@Valid @RequestBody ProductModel product){
        return ResponseEntity.created(null).build();
    }

}
