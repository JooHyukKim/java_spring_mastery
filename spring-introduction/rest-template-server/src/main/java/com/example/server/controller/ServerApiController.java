package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.Base64;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {
    // https://openapi.naver.com
    // /v1/search/local.xml
    //?query=%ea%b0%88%eb%b9%84%ec%a7%91
    //&display=10
    //&start=1
    //&sort=random
    @GetMapping("/naver")
    public String naver() {

        String query = "갈비집";
        String encoded = Base64.getEncoder().encodeToString(query.getBytes());

        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query", query)
                .queryParam("display", "10")
                .queryParam("start", "1")
                .queryParam("sort", "random")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", "nWrwCNTUMM9ok0k0DKfO")
                .header("X-Naver-Client-Secret", "Q6xRYECYQm")
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);

        return result.getBody();
    }

    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age) {
        User user = new User();
        user.setAge(age);
        user.setName(name);
        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public Req<User> post(
//            HttpEntity<String> entity
            @RequestBody Req<User> user
            , @PathVariable int userId
            , @PathVariable String userName
            , @RequestHeader("x-authorization") String authorization
            , @RequestHeader("custom-header") String customHeader
    ) {
        log.info("userId : {}", userId);
        log.info("userName : {}", userName);
        log.info("authorization : {}", authorization);
        log.info("customHeader : {}", customHeader);
        log.info("client req : {}", user);

        Req<User> response = new Req<>();
        response.setHeader(
                new Req.Header()
        );
        response.setResBody(user.getResBody());
        return response;
    }

}
