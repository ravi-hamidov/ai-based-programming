
public class App {

    public static void main(String[] args) {
        Book book = new Book("Effective Java", 59.99, "Joshua Bloch");
        Electronic laptop = new Electronic("MacBook Pro", 2499.99, "Apple");

        System.out.println("=== BEFORE DISCOUNT ===");
        book.displayInfo();
        System.out.println();
        laptop.displayInfo();

        // Endirim tetbiq edek
        book.applyDiscount(10);       // 10% endirim
        laptop.applyDiscount(15);     // 15% endirim

        System.out.println("\n=== AFTER DISCOUNT ===");
        book.displayInfo();
        System.out.println();
        laptop.displayInfo();
    }
}
