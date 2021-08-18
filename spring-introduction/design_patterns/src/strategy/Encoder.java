package strategy;

public class Encoder {
    private EncodingStrategy encodingStrategy;

    public String getMEssage(String message) {
        return this.encodingStrategy.encode(message);
    }

    public void setEncodingStrategy(EncodingStrategy encodingStrategy) {
        this.encodingStrategy = encodingStrategy;
    }
}
