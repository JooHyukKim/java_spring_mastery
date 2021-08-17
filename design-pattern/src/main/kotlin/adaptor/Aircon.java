package adaptor;

public class Aircon implements Elec220V{

    @Override
    public void connect() {
        System.out.println("에어컨");
    }
}
