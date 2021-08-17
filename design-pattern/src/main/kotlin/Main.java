import adaptor.*;
import proxy.Browser;

public class Main {

    public static void main(String[] args) {

        Browser browser = new Browser("www.naver.com");
        browser.show();

    }

    public static void connect(Elec110V e110){
        e110.powerOn();
    }
}
