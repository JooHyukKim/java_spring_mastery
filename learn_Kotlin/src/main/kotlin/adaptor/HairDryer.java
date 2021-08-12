package adaptor;

public class HairDryer implements Elec110V{


    @Override
    public void powerOn() {
        System.out.println("헤어드라기");
    }
}
