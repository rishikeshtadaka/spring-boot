package com.ecommerce.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorModel {
    public ErrorModel(String message,String description){
        this.timestamp=LocalDateTime.now();
        this.message=message;
        this.description=description;
    }
    private LocalDateTime timestamp;
    private String message;
    private String description;
}
