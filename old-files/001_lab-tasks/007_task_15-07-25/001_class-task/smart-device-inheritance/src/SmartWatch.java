
public class SmartWatch extends SmartDevice {

    private int batteryLevel;

    public SmartWatch(String brand, String model, int batteryLevel) {
        super(brand, model);
        this.batteryLevel = batteryLevel;
    }

    public void trackHeartRate() {
        if (isOnline) {
            System.out.println("Saat artiq melumat toplayir.");
        } else {
            System.out.println("Saat internete qosulmayib, melumat toplanmir.");
        }
    }

    public void showBatteryLevel() {
        System.out.println("Bateria seviyyesi: " + batteryLevel + "%");
    }

    @Override
    public void connectToWiFi() {
        super.connectToWiFi();
        System.out.println("SmartWatch internete qosuldu.");
    }

    @Override
    public void disconnect() {
        super.disconnect();
        System.out.println("SmartWatch baglanti kesildi.");
    }
}
