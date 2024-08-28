public class INter{
public static void main(String s[]){
    Remote remote = new Telivison();
    remote.powerOn();
    remote.volumeup();
    remote.volumedown();
    remote.powerOff();}

}
interface Remote {
    abstract public void volumeup();
    abstract public  void volumedown();
    abstract public void powerOff();
    abstract public void powerOn();
}
class Telivison implements Remote{

    @Override
    public void volumeup() {
        System.out.println("Volume UP ++++++");
    }

    @Override
    public void volumedown() {
        System.out.println("Volume Down -------");
    }

    @Override
    public void powerOff() {
        System.out.println("Power is off ");
    }

    @Override
    public void powerOn() {
        System.out.println("Power is on");
    }
}