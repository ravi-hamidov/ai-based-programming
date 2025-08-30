public class Clothing extends Product {
    private String size;

    public Clothing(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    @Override
    public void displayInfo() {
        System.out.println("Geyim Mehsulu: " + name);
        System.out.println("Olcu: " + size);
        System.out.println("Qiymet: $" + price);
    }
}
