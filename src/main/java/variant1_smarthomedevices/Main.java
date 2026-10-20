
package variant1_smarthomedevices;

public class Main {

    public static void main(String[] args) {

        SmartThermostat thermostat = new SmartThermostat();
        SmartLight light = new SmartLight();
        SmartCoffeeMaker coffeeMaker = new SmartCoffeeMaker();

        SmartHomeController controller = new SmartHomeController();

        OnOFF[] devices = {thermostat, light, coffeeMaker};

        for (OnOFF device : devices) {
            device.powerOn();
        }

        controller.changeTemperature(thermostat, 22);
        controller.changeBrightness(light, 50);
        controller.makeCoffee(coffeeMaker);

        controller.turnOnFavoriteRegime(thermostat, light, coffeeMaker);

        for (OnOFF device : devices) {
            device.powerOff();
        }
    }
}
