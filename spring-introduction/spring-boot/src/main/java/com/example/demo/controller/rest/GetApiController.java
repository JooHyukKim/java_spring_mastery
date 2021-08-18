package com.example.demo.controller.rest;

import com.example.demo.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    // NEW STYLE
    @GetMapping(path = "/new")
    public String getHello() {
        return "get hello";
    }

    // OLD STYLE
    @RequestMapping(value = "/old", method = RequestMethod.GET)
    public String hi() {
        return "old | get Hello";
    }

    // http://localhost:9090/api/get/path-variable/{name}
    // http://localhost:9090/api/get/path-variable/java
    // http://localhost:9090/api/get/path-variable/vince
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName, @PathVariable String name) {
        System.out.println("PathVariable : " + name);
        return "Hello, your name is...." + name + " // nice to meet you " + pathName + "!";
    }

    // https://www.youtube.com/watch
    // ?v=uxcYbzlv4sk
    // ?key=value&key2=value
    // http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path = "/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping("/query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        return name + " | " + email + " | " + age;
    }

    @GetMapping("/query-param03")
    public String queryParam03(UserRequest userRequest ) {
        return userRequest.toString();
    }



}
