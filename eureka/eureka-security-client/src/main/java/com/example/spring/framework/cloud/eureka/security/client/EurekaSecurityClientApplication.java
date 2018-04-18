package com.example.spring.framework.cloud.eureka.security.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaSecurityClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaSecurityClientApplication.class, args);
    }
}
