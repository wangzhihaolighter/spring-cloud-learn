package com.example.springframework.cloud.eurekaconsumerfeign.web;

import com.example.springframework.cloud.eurekaconsumerfeign.web.client.DemoEurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimpleController {

    @Autowired
    DemoEurekaClient demoEurekaClient;

    @RequestMapping("/")
    public String home(){
        return "eureka consumer feign";
    }

    @GetMapping("/consumer")
    public String consumer() {
        return demoEurekaClient.home();
    }

}
