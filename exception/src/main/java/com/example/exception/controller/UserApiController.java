package com.example.exception.controller;

import com.example.exception.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user2")
public class UserApiController {

    @GetMapping("")
    public User get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
        User user = new User();
        user.setAge(age);
        user.setName(name);
        int a = 10 + age;

        return user;
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user) {
        System.out.println(user);
        return user;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        System.out.println("LOCAL ::: MethodArgumentNotValidException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
