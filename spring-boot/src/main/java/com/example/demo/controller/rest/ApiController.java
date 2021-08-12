package com.example.demo.controller.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 Class는 Rest API 처리 하는 controller
@RequestMapping("/api") // URI를 지정해주는 Annotation
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
        return "hello spring boot!";
    }
}
