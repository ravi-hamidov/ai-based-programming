
public class App {

    public static void main(String[] args) {
        SmartWatch watch = new SmartWatch("Apple", "Watch Series 9", 85);
        SmartSpeaker speaker = new SmartSpeaker("Amazon", "Echo Dot");
        SmartFridge fridge = new SmartFridge("Samsung", "SmartCool 3000", 3);

        // Watch 
        watch.connectToWiFi();
        watch.trackHeartRate();
        watch.showBatteryLevel();
        watch.disconnect();

        System.out.println("\n----------------------\n");

        // Speaker
        speaker.connectToWiFi();
        speaker.playMusic();
        speaker.volumeUp();
        speaker.volumeUp();
        speaker.disconnect();

        System.out.println("\n----------------------\n");

        // Fridge 
        fridge.connectToWiFi();
        fridge.showTemperature();
        fridge.addProduct("Sud");
        fridge.addProduct("Terevez");
        fridge.listProducts();
    }
}
