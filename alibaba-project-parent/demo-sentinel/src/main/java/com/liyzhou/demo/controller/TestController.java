package com.liyzhou.demo.controller;

import com.liyzhou.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService service;

    @GetMapping(value = "/hello")
    public String apiHello() {
        return service.sayHello("xxxx");
    }
}