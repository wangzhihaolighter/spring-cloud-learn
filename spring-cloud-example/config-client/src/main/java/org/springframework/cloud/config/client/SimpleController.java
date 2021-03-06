package org.springframework.cloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @Value("${foo}")
    String foo;

    @GetMapping("/foo")
    public String hi() {
        return foo;
    }
}
