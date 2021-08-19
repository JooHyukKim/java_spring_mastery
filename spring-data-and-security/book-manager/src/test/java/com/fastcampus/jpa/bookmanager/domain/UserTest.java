package com.fastcampus.jpa.bookmanager.domain;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Test
    void userTest() {
        User user = new User();
        user.setEmail("beanskobe@fastcampus.com");
        user.setName("JooHyuk");

        System.out.println(">>>> " + user.toString());
    }

}
