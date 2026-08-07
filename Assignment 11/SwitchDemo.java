package jav;
interface Switchable {

    void turnOn();

}
class Light implements Switchable {

    public void turnOn() {

        System.out.println("Light is turned ON");
    }
}
class Fan implements Switchable {

    public void turnOn() {

        System.out.println("Fan is turned ON");
    }
}
public class SwitchDemo {

    public static void main(String args[]) {

        Light l = new Light();
        Fan f = new Fan();

        l.turnOn();

        f.turnOn();
    }
}

