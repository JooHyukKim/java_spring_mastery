package com.example.demo;

import com.example.demo.IEncoder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

public class Encoder {

    private IEncoder iEncoder;

    public Encoder() {
        this.iEncoder = new Base64Encoder();
    }

    // 클래스명 start with 소문자나
    // component 만 사용.
    public Encoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }


    public String encode(String msg) throws UnsupportedEncodingException {
        return iEncoder.encode(msg);
    }

    public void setIEncoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }
}
