package com.example.validation.controller;

import com.example.validation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError filed = (FieldError) objectError;
                String message = objectError.getDefaultMessage();

                sb.append("filed : " + filed.getField());
                sb.append("message : " + message);
            });
            return ResponseEntity.badRequest().body(sb.toString());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
