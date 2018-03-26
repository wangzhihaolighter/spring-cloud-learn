package com.example.springframework.cloud.demoeurekaclient.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }
}
