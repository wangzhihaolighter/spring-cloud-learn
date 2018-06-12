package com.example.springframework.cloud.demo.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaClientApplication.class, args);
    }
}
