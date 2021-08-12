package com.example.demo;

import java.io.UnsupportedEncodingException;

public interface IEncoder {
    String encode(String mesg) throws UnsupportedEncodingException;
}
