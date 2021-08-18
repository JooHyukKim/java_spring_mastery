package adaptor;

public class Vacuum implements Elec220V{

    @Override
    public void connect() {
        System.out.println("Vacuum 220v on");
    }
}
