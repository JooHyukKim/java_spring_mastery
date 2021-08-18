import decorator.*;
import facade.FTP;
import facade.Reader;
import facade.SftpClient;
import facade.Writer;
import observer.Button;
import observer.IButtonListener;
import strategy.*;

public class Main {

    public static void main(String[] args) {
//        decoratorPattern();
//        observerpattern();
//        facadePatternBefore();
//        facadePatternAfter();
        strategyPattern();
    }

    public static void strategyPattern() {
        Encoder encoder = new Encoder();
        EncodingStrategy base64 = new Base64Strategy();
        EncodingStrategy normal = new NormalStrategy();

        String message = "hello java";

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMEssage(message);
        System.out.println(base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMEssage(message);
        System.out.println(normalResult);

        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMEssage(message);
        System.out.println(appendResult);
    }

    public static void facadePatternAfter() {
        SftpClient sftpClient = new SftpClient("www.or.kr", 22, "/home/etc", "text.tmp");
        sftpClient.connect();
        sftpClient.disconnect();
    }

    public static void observerpattern() {
        Button button = new Button("버튼");
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });

        button.click("메시지 전달 클릭 1");
        button.click("메시지 전달 클릭 2");
        button.click("메시지 전달 클릭 3");
        button.click("메시지 전달 클릭 4");
    }

    public static void facadePatternBefore() {
        FTP ftpclient = new FTP("www.or.kr", 22, "/home/etc");
        ftpclient.connect();
        ftpclient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpclient.disconnect();
    }

    public static void decoratorPattern() {
        ICar audi = new Audi(1000);
        audi.showPrice();

        ICar a3 = new A3(audi, "A3");
        a3.showPrice();

        ICar a4 = new A4(audi, "A4");
        a4.showPrice();

        ICar a5 = new A5(audi, "A5");
        a5.showPrice();
    }
}
