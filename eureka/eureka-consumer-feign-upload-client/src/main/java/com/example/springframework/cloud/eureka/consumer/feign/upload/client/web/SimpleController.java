package com.example.springframework.cloud.eureka.consumer.feign.upload.client.web;

import com.example.springframework.cloud.eureka.consumer.feign.upload.client.web.client.EurekaConsumerFeignUploadServerClient;
import com.example.springframework.cloud.eureka.consumer.feign.upload.client.web.client.DemoEurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class SimpleController {

    @Autowired
    DemoEurekaClient demoEurekaClient;

    @Autowired
    EurekaConsumerFeignUploadServerClient eurekaConsumerFeignUploadServerClient;

    @RequestMapping("/")
    public String home() {
        return "eureka consumer feign upload client";
    }

    @GetMapping("/consumer")
    public String consumer() {
        return demoEurekaClient.home();
    }

    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
        return eurekaConsumerFeignUploadServerClient.handleFileUpload(file);
    }


}
