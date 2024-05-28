package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController             // REST API 처리하는 Controller
@RequestMapping("/api")     // URI 지정
public class ApiController {

    @GetMapping("/hello")   // Get 요청, http://localhost:8080/api/hello
    public String hello() {
        return "hello spring boot!";
    }
}
