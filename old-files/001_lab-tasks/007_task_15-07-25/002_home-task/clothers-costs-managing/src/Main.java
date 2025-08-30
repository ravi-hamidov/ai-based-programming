public class Main {
    public static void main(String[] args) {
        Book book = new Book("Java Programming", 45.0, "James Gosling");
        Electronic laptop = new Electronic("Laptop", 1005.0, "Dell");
        Clothing tshirt = new Clothing("T-Shirt", 25.0, "L");
        Technology smartphone = new Technology("Smartphone X", 805.0, 2);

        // Endirim tetbiq olunur
        book.applyDiscount(10); // 10% endirim
        laptop.applyDiscount(15); // 15% endirim
        tshirt.applyDiscount(15); // 15% endirim
        smartphone.applyDiscount(20); // 20% endirim

        book.displayInfo();
        System.out.println();

        laptop.displayInfo();
        System.out.println();

        tshirt.displayInfo();
        System.out.println();

        smartphone.displayInfo();
    }
}
