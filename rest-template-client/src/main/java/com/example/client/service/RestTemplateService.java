package com.example.client.service;

import com.example.client.dto.Req;
import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    // localhost:/api/server/hello
    // response
    public UserResponse hello() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name", "aaaeven")
                .queryParam("age", 990)
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        // way 1
//        String result = restTemplate.getForObject(uri, String.class);

        // way 2
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);
        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        return result.getBody();
    }

    public UserResponse post() {
        // http://localhost:9090/api/server/user/{userId}/name/{userName}
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "steven")
                .toUri();

        System.out.println(uri.toString());


        // http body -> object 전송 -> Object Mapper -> json -> rest template -> http body json
        UserRequest userRequest = new UserRequest();
        userRequest.setAge(10);
        userRequest.setName("setve");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri, userRequest, UserResponse.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());


        return response.getBody();
    }

    public UserResponse exchange() {
        // http://localhost:9090/api/server/user/{userId}/name/{userName}
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "steven")
                .toUri();

        System.out.println(uri.toString());


        // http body -> object 전송 -> Object Mapper -> json -> rest template -> http body json
        UserRequest userRequest = new UserRequest();
        userRequest.setAge(10);
        userRequest.setName("setve");

        RequestEntity<UserRequest> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header", "fffff")
                .body(userRequest);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.exchange(requestEntity, UserResponse.class);

        return response.getBody();
    }

    public Req<UserResponse> genericExchange() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "steven")
                .toUri();

        System.out.println(uri.toString());

        // http body -> object 전송 -> Object Mapper -> json -> rest template -> http body json
        UserRequest userRequest = new UserRequest();
        userRequest.setAge(10);
        userRequest.setName("setve");

        Req<UserRequest> req = new Req<>();
        req.setHeader(
                new Req.Header()
        );
        req.setResBody(
                userRequest
        );


        RequestEntity<Req<UserRequest>> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header", "fffff")
                .body(req);


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Req<UserResponse>> response
                = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Req<UserResponse>>() {
        });

        return response.getBody();
    }
}






















