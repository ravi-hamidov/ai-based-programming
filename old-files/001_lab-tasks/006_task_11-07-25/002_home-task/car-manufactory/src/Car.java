
public class Car {

    private String model;
    private Manufacturer manufacturer;
    private int productionYear;
    private double engineSize;
    private String fuelType;
    private double price;

    public Car(String model, Manufacturer manufacturer, int productionYear, double engineSize, String fuelType, double price) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.productionYear = productionYear;
        this.engineSize = engineSize;
        this.fuelType = fuelType;
        this.price = price;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getPrice() {
        return price;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public boolean isLuxury() {
        return price > 40;
    }

    @Override
    public String toString() {
        return model + " | " + manufacturer.getName() + " | " + productionYear + " | " + engineSize + "L | " + fuelType + " | $" + price + "K";
    }
}
