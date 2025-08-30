public abstract class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Abstrakt metod - her alt sinifde implementasiya olunacaq
    public abstract void displayInfo();

    // Endirim tetbiq eden metod
    public void applyDiscount(double percent) {
        price = price - (price * percent / 100);
    }
}
