package com.example.demo.controller;

import com.example.demo.dto.PutRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put")
    public void put(@RequestBody PutRequestDTO putRequestDTO) {
        System.out.println(putRequestDTO);
    }

    @PutMapping("/put/{userId}")
    public void put(@RequestBody PutRequestDTO putRequestDTO, @PathVariable(name = "userId") Long id) {
        System.out.println(putRequestDTO);
    }

}