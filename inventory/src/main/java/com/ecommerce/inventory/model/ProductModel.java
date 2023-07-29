package com.ecommerce.inventory.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductModel {
    private Integer Id;
    @Size(min = 2,message = "product name must be more than 2 characters")
    @NotBlank(message = "product name is required")
    @JsonProperty("productName")
    private String name;
}
