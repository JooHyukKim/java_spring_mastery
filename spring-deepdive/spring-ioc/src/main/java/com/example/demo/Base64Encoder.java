package com.example.demo;

import org.springframework.stereotype.Component;

@Component("base64encoder")
public class Base64Encoder  implements IEncoder{
    public String encode(String mesg) {
        return mesg;
    }
}
