package com.example.spring.framework.cloud.eureka.security.client.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @RequestMapping("/")
    public String home() {
        return "eureka security client";
    }
}
