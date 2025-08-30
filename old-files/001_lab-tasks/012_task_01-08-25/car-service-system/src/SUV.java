
public class SUV extends Car implements Serviceable {

    private boolean isFourWheelDrive;

    public SUV(String brand, String model, int year, boolean isFourWheelDrive) {
        super(brand, model, year);
        this.isFourWheelDrive = isFourWheelDrive;
    }

    @Override
    public void displayInfo() {
        System.out.println("SUV: " + getBrand() + " " + getModel() + ", Istesal Ili: " + getYear() + ", 4x4: " + isFourWheelDrive + ".");
    }

    @Override
    public double calculateServiceCost() {
        return 250.0;
    }

    @Override
    public void performInspection() {
        System.out.println(getBrand() + " " + getModel() + " avtomobiline texniki baxis edildi.");
    }
}
