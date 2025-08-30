
public class Book extends Product {

    private String author;

    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book: " + name);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
}
