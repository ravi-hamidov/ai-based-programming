import java.util.ArrayList;

class Library {
    private String name;
    private ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Kitab elave olundu: " + book.getTitle());
    }

    public void borrowBook(String title) throws BookNotFoundException, BookAlreadyBorrowedException {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.borrowBook();
                return;
            }
        }
        throw new BookNotFoundException("Kitab tapilmadi: " + title);
    }

    public void returnBook(String title) throws BookNotFoundException, BookNotBorrowedException {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                return;
            }
        }
        throw new BookNotFoundException("Kitab tapilmadi: " + title);
    }

    public void printAllBooks() {
        System.out.println(name + " kitabxanasindakı kitablar:");
        for (Book book : books) {
            book.printInfo();
        }
    }
}