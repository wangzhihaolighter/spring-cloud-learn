package org.springframework.cloud.eureka.feign.client;

import feign.Retryer;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignConfig {

    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default();
    }

    /**
     * 支持文件上传
     */
    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder();
    }

}
