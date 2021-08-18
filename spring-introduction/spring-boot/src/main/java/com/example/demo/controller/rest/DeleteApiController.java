package com.example.demo.controller.rest;

import com.example.demo.dto.PutRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteApiController {

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable(value = "userId") String userId, @RequestParam String account) {
        System.out.println(userId);
        System.out.println(account);
        System.out.println("-");
    }

}