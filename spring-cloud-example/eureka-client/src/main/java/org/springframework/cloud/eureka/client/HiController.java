package org.springframework.cloud.eureka.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HiController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/")
    public String hello() {
        return "Hello,World!";
    }

    @GetMapping("/hi")
    public String home(@RequestParam(name = "name") String name) {
        return "hi " + name + ",l am from port : " + port;
    }

    @GetMapping("/testRest")
    public String testRest() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://www.baidu.com/", String.class);
    }
}