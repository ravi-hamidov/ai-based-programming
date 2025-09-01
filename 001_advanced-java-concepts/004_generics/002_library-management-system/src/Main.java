import java.util.*;
public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();

        myLibrary.addBook(new Book("1984", "George Orwell"));
        myLibrary.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien"));
        myLibrary.addBook(new Book("Pride and Prejudice", "Jane Austen"));

        myLibrary.printAllBooks();

        // --- BONUS TESTİ ---
        // 'extends' testi için bir kitap listesi oluşturuyoruz
        List<Book> bookListForReading = new ArrayList<>();
        bookListForReading.add(new Book("Fahrenheit 451", "Ray Bradbury"));
        myLibrary.printBooksExtends(bookListForReading);

        // 'super' testi için bir liste oluşturuyoruz
        List<Object> objectListForWriting = new ArrayList<>();
        myLibrary.addBooksSuper(objectListForWriting);
        System.out.println("'super' testinden sonra Object listesi: " + objectListForWriting);
    }
}