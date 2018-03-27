package com.example.springframework.cloud.eurekaconsumerribbon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimpleController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/")
    public String home(){
        return "eureka consumer ribbon";
    }

    @GetMapping("/consumer")
    public String consumer() {
        String url = "http://demo-eureka-client/";
        return restTemplate.getForObject(url, String.class);
    }

}
