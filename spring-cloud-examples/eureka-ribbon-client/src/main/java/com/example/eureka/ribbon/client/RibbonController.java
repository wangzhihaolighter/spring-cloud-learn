package com.example.eureka.ribbon.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {
    @Autowired
    RibbonService ribbonService;

    @GetMapping("/")
    public String hi(@RequestParam("name") String name) {
        return ribbonService.hi(name);
    }
}
