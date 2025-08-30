
public class Electronic extends Product {

    private String brand;

    public Electronic(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    @Override
    public void displayInfo() {
        System.out.println("Electronic: " + name);
        System.out.println("Brand: " + brand);
        System.out.println("Price: $" + price);
    }
}
