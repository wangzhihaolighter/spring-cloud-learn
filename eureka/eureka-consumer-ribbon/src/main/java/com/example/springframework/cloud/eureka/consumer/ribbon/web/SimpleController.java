package com.example.springframework.cloud.eureka.consumer.ribbon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimpleController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/")
    public String home() {
        return "eureka consumer ribbon";
    }

    @GetMapping("/consumer")
    public String consumer() {
        return restTemplate.getForObject("http://demo-eureka-client/", String.class);
    }

}
