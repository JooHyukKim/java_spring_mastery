package adaptor;

public class SocketAdapter implements Elec110V {

    private Elec220V elec220V;

    public SocketAdapter(Elec220V elec220V) {
        this.elec220V = elec220V;
    }



    @Override
    public void powerOn() {

    }
}
