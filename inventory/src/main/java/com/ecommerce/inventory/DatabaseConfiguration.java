package com.ecommerce.inventory;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "database")
@Component
@Getter
@Setter
public class DatabaseConfiguration {
    public String password;
    public String userName;
}
