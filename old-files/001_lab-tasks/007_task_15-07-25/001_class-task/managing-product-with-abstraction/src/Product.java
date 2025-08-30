
public abstract class Product {

    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void displayInfo();

    public void applyDiscount(double percent) {
        price = price - (price * percent / 100);
    }
}
