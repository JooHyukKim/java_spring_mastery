package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        SpringApplication.run(DemoApplication.class, args);
        ApplicationContext context = ApplicationContextProvider.getContext();

//        Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);



        Encoder encoder = context.getBean("base64encode", Encoder.class);
        String result = encoder.encode(url);
        System.out.println(result);
    }

}

@Configuration
class AppConfig {

    @Bean("base64encode")
    public Encoder encoder(Base64Encoder base64Encoder) {
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder) {
        return new Encoder(urlEncoder);
    }


}
