
package variant1_smarthomedevices;

public class SmartCoffeeMaker implements OnOFF, CoffeeMaker {

    @Override
    public void powerOn() {
        System.out.println("Coffee maker powered on.");
    }

    @Override
    public void powerOff() {
        System.out.println("Coffee maker powered off.");
    }

    @Override
    public void brewCoffee() {
        System.out.println("Brewing fresh coffee...");
    }
}
