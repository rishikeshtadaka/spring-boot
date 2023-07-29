package com.ecommerce.productservices.controllers;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Resilience4jController {
    private Logger logger= LoggerFactory.getLogger(Resilience4jController.class);
    @GetMapping("/sample-api")
    @Retry(name="default",fallbackMethod = "hardcodedResponse")
    public String sampleApi(){
        this.logger.info("Sample API");
        ResponseEntity<String> forEntity=new RestTemplate().getForEntity("https://www.google.com1/",String.class);
        return forEntity.getBody();
    }

    @GetMapping("/sample-api-circuit-breaker")
    @CircuitBreaker(name="default",fallbackMethod = "hardcodedResponse")
    public String sampleApiCircuitBreaker(){
        this.logger.info("sample-api-circuit-breaker");
        ResponseEntity<String> forEntity=new RestTemplate().getForEntity("https://www.google.com1/",String.class);
        return forEntity.getBody();
    }

    @GetMapping("/sample-api-rate-limiting")
    @RateLimiter(name="default",fallbackMethod = "hardcodedResponse")
    public String sampleApiRateLimiting(){
        this.logger.info("sample-api-rate-limiting");
        return "sample-api-rate-limiting";
    }

    @GetMapping("/sample-api-rate-limiting-sample-name")
    @RateLimiter(name="sample-name",fallbackMethod = "hardcodedResponse")
    public String sampleApiRateLimitingSampleName(){
        this.logger.info("sample-api-rate-limiting");
        return "sample-api-rate-limiting";
    }

    @GetMapping("/sample-api-bulk-head")
    @Bulkhead(name="default",fallbackMethod = "hardcodedResponse")
    public String sampleApiBulkHead(){
        this.logger.info("sample-api-bulk-head");
        return "sample-api-bulk-head";
    }

    public String hardcodedResponse(Exception e){
        return "fallback-response";
    }
}
