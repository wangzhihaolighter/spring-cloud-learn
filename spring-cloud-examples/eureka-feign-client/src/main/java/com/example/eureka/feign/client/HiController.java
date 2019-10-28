package com.example.eureka.feign.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Autowired
    private EurekaClientFeign eurekaClientFeign;

    @GetMapping("/")
    public String sayHi(@RequestParam(name = "name") String name) {
        return eurekaClientFeign.sayHiFromClientEureka(name);
    }
}
