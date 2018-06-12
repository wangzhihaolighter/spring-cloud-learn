package com.example.springframework.cloud.eureka.consumer.feign.web;

import com.example.springframework.cloud.eureka.consumer.feign.web.client.DemoEurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @Autowired
    DemoEurekaClient demoEurekaClient;

    @RequestMapping("/")
    public String home() {
        return "eureka consumer feign";
    }

    @GetMapping("/consumer")
    public String consumer() {
        return demoEurekaClient.home();
    }

}
