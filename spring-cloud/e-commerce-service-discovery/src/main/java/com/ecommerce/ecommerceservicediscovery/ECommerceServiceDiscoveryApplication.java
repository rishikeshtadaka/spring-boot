package com.ecommerce.ecommerceservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ECommerceServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceServiceDiscoveryApplication.class, args);
	}

}
