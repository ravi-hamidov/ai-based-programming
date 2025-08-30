
public class Sedan extends Car implements Serviceable {

    private int doorCount;

    public Sedan(String brand, String model, int year, int doorCount) {
        super(brand, model, year);
        this.doorCount = doorCount;
    }

    @Override
    public void displayInfo() {
        System.out.println("Sedan: " + getBrand() + " " + getModel() + ", Istesal Ili: " + getYear() + ", Qapi Sayi: " + doorCount + ".");
    }

    @Override
    public double calculateServiceCost() {
        return 150.0;
    }

    @Override
    public void performInspection() {
        System.out.println(getBrand() + " " + getModel() + " avtomobiline texniki baxis edildi.");
    }
}
