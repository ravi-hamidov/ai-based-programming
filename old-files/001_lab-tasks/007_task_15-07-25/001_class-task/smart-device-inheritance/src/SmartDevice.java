
public class SmartDevice {

    protected String brand;
    protected String model;
    protected boolean isOnline;

    public SmartDevice(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.isOnline = false;
    }

    public void connectToWiFi() {
        isOnline = true;
        System.out.println(brand + " " + model + " internete qosuldu.");
    }

    public void disconnect() {
        isOnline = false;
        System.out.println(brand + " " + model + " internet baglantisi kesildi.");
    }

    public void showStatus() {
        System.out.println(brand + " " + model + " statusu: " + (isOnline ? "online" : "offline"));
    }
}
