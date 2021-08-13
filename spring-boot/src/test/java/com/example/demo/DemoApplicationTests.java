package com.example.demo;

import com.example.demo.objectmapper.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("hello");

        // Text JSON -> Object
        // Object -> Text JSON

        // controller req json(text) ->  object
        /// response object -> json(text)

        var objectmapper = new ObjectMapper();

        // object -> text
        // object mapper는 get으로 시작하는 method들 모두를 활용하기 때문에 objectMapper를 활용할 클래스라면 get을 빼고 작성해야한다.

        var user = new User("steve", 10, "010-3419-3200");
        var text = objectmapper.writeValueAsString(user);
        System.out.println(text);

        // text -> object
        var objectUser = objectmapper.readValue(text, User.class);
        System.out.println(objectUser);
    }

}

