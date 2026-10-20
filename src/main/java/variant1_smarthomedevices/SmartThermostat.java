
package variant1_smarthomedevices;

public class SmartThermostat implements OnOFF, ChangeTemperature {

    @Override
    public void powerOn() {
        System.out.println("Thermostat powered on.");
    }

    @Override
    public void powerOff() {
        System.out.println("Thermostat powered off.");
    }

    @Override
    public void setTemperature(double temp) {
        System.out.println("Temperature set to " + temp + "°C.");
    }
}
