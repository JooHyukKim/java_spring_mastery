package com.example.demo.controller.rest;

import com.example.demo.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 해당 Class는 Rest API 처리 하는 controller
@RequestMapping("/api/response") // URI를 지정해주는 Annotation
public class RestApiController {

    // TEXT 내려주기
    // http://localhost:9090/api/response/text?account=user01
    @GetMapping("/text")
    public String hello(@RequestParam String account) {
        return account;
    }

    // JSON 내려주기
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user;
    }

    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
