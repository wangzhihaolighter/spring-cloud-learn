package com.example.springframework.cloud.democonfigdatasourceclient.web;

import com.example.springframework.cloud.democonfigdatasourceclient.dao.PersonRepository;
import com.example.springframework.cloud.democonfigdatasourceclient.dao.UserRepository;
import com.example.springframework.cloud.democonfigdatasourceclient.entity.Person;
import com.example.springframework.cloud.democonfigdatasourceclient.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String home() {
        return "demo config datasource client";
    }

    @GetMapping("/consumer")
    public String consumer() {
        return "demo config datasource client server port:"+serverPort;
    }

    @GetMapping("/consumer/person")
    public Person consumerPerson() {
        return personRepository.findById(1L).get();
    }

    @GetMapping("/consumer/user")
    public User consumerUser() {
        return userRepository.findById(1L).get();
    }

}
