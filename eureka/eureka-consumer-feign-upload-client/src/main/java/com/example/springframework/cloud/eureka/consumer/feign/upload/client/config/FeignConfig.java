package com.example.springframework.cloud.eureka.consumer.feign.upload.client.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    /**
     * 支持文件上传
     */
    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder();
    }

}
