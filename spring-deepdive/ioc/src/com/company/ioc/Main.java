package com.company.ioc;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // Base64

        // url encoding
        Encoder encoder = new Encoder();
        String result = encoder.encode(url);
        System.out.println(result);

        Base64Encoder encoder1 = new Base64Encoder();
        String rs = encoder.encode(url);
        System.out.println(rs);

        UrlEncoder urlEncoder = new UrlEncoder();
        String urlREsult = urlEncoder.encode(url);
        System.out.println(urlREsult);

        System.out.println("DI ------------------------------");

        // DI
        Encoder enc1 = new Encoder(new Base64Encoder());
        String res1 = enc1.encode(url);
        System.out.println(res1);

    }
}