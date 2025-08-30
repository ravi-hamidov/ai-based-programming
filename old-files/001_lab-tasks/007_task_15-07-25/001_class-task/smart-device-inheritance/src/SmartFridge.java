
import java.util.ArrayList;

public class SmartFridge extends SmartDevice {

    private int coolingLevel;
    private ArrayList<String> products;

    public SmartFridge(String brand, String model, int coolingLevel) {
        super(brand, model);
        this.coolingLevel = coolingLevel;
        this.products = new ArrayList<>();
    }

    public void showTemperature() {
        if (isOnline) {
            System.out.println("Soyutma seviyyesi: " + coolingLevel);
        } else {
            System.out.println("Soyuducu offlinedir, temperaturu gostermek olmur.");
        }
    }

    public void addProduct(String product) {
        products.add(product);
        System.out.println("Mehsul elave olundu: " + product);
    }

    public void listProducts() {
        System.out.println("Soyuducudaki mehsullar:");
        for (String product : products) {
            System.out.println("- " + product);
        }
    }

    @Override
    public void connectToWiFi() {
        super.connectToWiFi();
        System.out.println("Soyuducu mehsullarin siyahisini sinxronlasdirir.");
    }

    @Override
    public void disconnect() {
        super.disconnect();
        System.out.println("Soyuducu bağlantı kəsildi.");
    }
}
