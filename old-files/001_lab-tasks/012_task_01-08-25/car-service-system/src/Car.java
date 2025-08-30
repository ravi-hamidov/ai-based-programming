
public class Car implements Serviceable {

    private String brand;
    private String model;
    private int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Getter ve setter metodlari
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Avtomobil: " + brand + " " + model + ", Istehsal ili: " + year + ".");
    }

    @Override
    public void performInspection() {
        System.out.println("Inspection performed for " + brand + " " + model + ".");
    }

    @Override
    public double calculateServiceCost() {
        double baseCost = 100.0;
        if (year < 2015) {
            baseCost += 50.0;
        }
        return baseCost;
    }
}
