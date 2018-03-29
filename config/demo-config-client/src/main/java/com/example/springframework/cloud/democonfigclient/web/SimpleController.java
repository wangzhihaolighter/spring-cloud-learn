package com.example.springframework.cloud.democonfigclient.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class SimpleController {

    @Value(value = "${info.profile}")
    private String infoProfile;

    @Value(value = "${info.username}")
    private String infoUsername;

    @RequestMapping("/")
    public String home() {
        return "demo config client";
    }

    @GetMapping("/consumer")
    public String consumer() {
        return infoProfile + ":" + infoUsername;
    }

}
