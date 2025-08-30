
public class App {

    public static void main(String[] args) {
        Book myBook = new Book("Java 101", "John Smith", 120);

        System.out.println("Book: " + myBook.getName());

        myBook.setName("Java Programming Language");
        myBook.setPageCount(35);

        System.out.println("Updated Book: " + myBook.getName()
                + ", Pages: " + myBook.getPageCount());
    }
}
