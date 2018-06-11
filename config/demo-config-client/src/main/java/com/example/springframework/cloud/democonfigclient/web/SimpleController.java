package com.example.springframework.cloud.democonfigclient.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
        return "[ profile ] " + infoProfile + " , [ username ] " + infoUsername;
    }

    /*
      刷新配置 actuator中开放refresh端点，post方式访问actuator的refresh接口，即可刷新配置
      如：http://localhost:9001/actuator/refresh
     */

    @GetMapping("/refresh")
    public String refresh() {
        String url = "http://localhost:9001/actuator/refresh";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);
        return restTemplate.postForObject(url, requestEntity, String.class);
    }

}
