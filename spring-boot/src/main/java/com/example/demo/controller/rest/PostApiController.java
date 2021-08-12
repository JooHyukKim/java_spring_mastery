package com.example.demo.controller.rest;

import com.example.demo.dto.PostRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {
    @PostMapping("/post")
    public void post(@RequestBody  Map<String, Object> requestData){
        requestData.entrySet().forEach(stringObjectEntry -> {
            System.out.println("key : " + stringObjectEntry.getKey());
            System.out.println("value : " + stringObjectEntry.getValue());
        });

//        requestData.forEach((key, value) -> System.out.println("key : " +));

    }

    @PostMapping("post2")
    public void post(@RequestBody PostRequestDTO postRequestDTO){
        System.out.println(postRequestDTO);
    }
}
