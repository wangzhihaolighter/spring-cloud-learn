package com.example.spring.framework.cloud.eureka.server.high.availability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerHighAvailabilityApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerHighAvailabilityApplication.class, args);
    }
}
