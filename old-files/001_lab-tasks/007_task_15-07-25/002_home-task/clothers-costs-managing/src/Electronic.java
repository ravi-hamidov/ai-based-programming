public class Electronic extends Product {
    private String brand;

    public Electronic(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    @Override
    public void displayInfo() {
        System.out.println("Elektron Mehsul: " + name);
        System.out.println("Brend: " + brand);
        System.out.println("Qiymet: $" + price);
    }
}
