package strategy;

import java.util.Base64;

public class AppendStrategy implements EncodingStrategy {

    @Override
    public String encode(String text) {
        return text + "ABCD";
    }


}
