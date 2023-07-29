package com.ecommerce.adminservices.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "database")
@Component
@Getter
@Setter
public class Configuration {
    private String password;
    private String username;
}