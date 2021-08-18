package com.company.ioc;

import java.util.Base64;

public class Encoder {

    private IEncoder encoder;

    public Encoder() {
        this.encoder = new Base64Encoder();
    }

    public Encoder(IEncoder encoder) {
        this.encoder = encoder;
    }

    public String encode(String msg) {
        return encoder.encode(msg);
    }
}
