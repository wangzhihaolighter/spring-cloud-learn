package com.example.springframework.cloud.eurekaconsumerfeignuploadserver.web;

import com.example.springframework.cloud.eurekaconsumerfeignuploadserver.web.client.DemoEurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;

@RestController
public class SimpleController {

    @Autowired
    DemoEurekaClient demoEurekaClient;

    @RequestMapping("/")
    public String home() {
        return "eureka consumer feign upload server";
    }

    @GetMapping("/consumer")
    public String consumer() {
        return demoEurekaClient.home();
    }

    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
        String result = null;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(file.getInputStream());
            int len = 0;
            int temp;
            byte[] fileContent = new byte[bufferedInputStream.available()];
            while ((temp = bufferedInputStream.read()) != -1) {
                fileContent[len] = (byte) temp;
                len++;
            }
            result = new String(fileContent);
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}
