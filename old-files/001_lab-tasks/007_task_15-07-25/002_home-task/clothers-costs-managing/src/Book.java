public class Book extends Product {
    private String author;

    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    @Override
    public void displayInfo() {
        System.out.println("Kitab Adi: " + name);
        System.out.println("Muellif: " + author);
        System.out.println("Qiymet: $" + price);
    }
}
