
package variant1_smarthomedevices;

public class SmartHomeController {

    public void changeTemperature(ChangeTemperature device, double temp) {
        device.setTemperature(temp);
    }

    public void changeBrightness(SwitchLight device, int level) {
        device.setBrightness(level);
    }

    public void makeCoffee(CoffeeMaker device) {
        device.brewCoffee();
    }

    public void turnOnFavoriteRegime(
            ChangeTemperature device1,
            SwitchLight device2,
            CoffeeMaker device3) {

        device1.setTemperature(25);
        device2.setBrightness(75);
        device3.brewCoffee();
    }
}
