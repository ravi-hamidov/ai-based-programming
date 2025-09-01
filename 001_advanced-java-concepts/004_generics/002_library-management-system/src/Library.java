import java.util.*;

public class Library {
    private ArrayList<Book> books;

    public Library(){
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println(book + "kitab kitabxanaya elave edildi");
    }

    public void printAllBooks() {
        System.out.println("Kitabxana");
        if(books.isEmpty()) {
            System.out.println("Kitabxana bosdur.");
        } else {
            for ( Book book : books) {
                System.out.println("- " + book);
            }
        }
        System.out.println("--------------------------");
    }

    public void printBooksExtends(List<? extends Book> list) {
        for (Book book : list) {
            System.out.println(book);
        }
        // list.add(new Book("New Book", "Author")); // XƏTA: 'extends' istifadə olunan listə yazmaq olmaz!
    }

    public void addBooksSuper(List<? super Book> list) {
        list.add(new Book("Animal Farm", "George Orwell"));
        list.add(new Book("The Hobbit", "J.R.R. Tolkien"));
        System.out.println("Yeni kitaplar 'super' listesine eklendi.");

        Object obj = list.getFirst();
    }

}
