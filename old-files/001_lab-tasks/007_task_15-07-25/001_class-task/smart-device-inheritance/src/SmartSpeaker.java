
public class SmartSpeaker extends SmartDevice {

    private int volume = 5; // default

    public SmartSpeaker(String brand, String model) {
        super(brand, model);
    }

    public void playMusic() {
        if (isOnline) {
            System.out.println("Sesguclendirici musiqi yayimlaga hazirdir.");
        } else {
            System.out.println("Sesguclendirici offlinedir, musiqi yayimlanmadi.");
        }
    }

    public void volumeUp() {
        if (volume < 10) {
            volume++;
            System.out.println("Ses seviyyasi artirildi: " + volume);
        } else {
            System.out.println("Maksimum ses seviyyesine catilib.");
        }
    }

    @Override
    public void connectToWiFi() {
        super.connectToWiFi();
        System.out.println("SmartSpeaker internete qosuldu.");
    }

    @Override
    public void disconnect() {
        super.disconnect();
        System.out.println("SmartSpeaker baglanti kesildi.");
    }
}
