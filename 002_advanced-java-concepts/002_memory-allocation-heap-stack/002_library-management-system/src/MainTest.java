public class MainTest {
    public static void main(String[] args) {
        Library library = new Library("Baku Book Center");

        // Test uchun elave olunmush example'lar
        library.addBook(new Book("Cinayet və Ceza", "Fyodor Dostoyevski"));
        library.addBook(new Book("Eli və Nino", "Qurban Seid"));
        library.addBook(new Book("1984", "George Orwell"));

        library.printAllBooks();

        try {
            // Kitab borrow et
            library.borrowBook("1984");

            // Eyni kitabı ikinci defe borrow edende exception atacaq
            library.borrowBook("1984");

        } catch (Exception e) {
            System.out.println("Xeta: " + e.getMessage());
        }

        try {
            // Kitabı qaytarmaq
            library.returnBook("1984");

            // Olmuyan kitab'i qaytaranda exception atmali
            library.returnBook("1984");

        } catch (Exception e) {
            System.out.println("Xeta: " + e.getMessage());
        }

        try {
            // Kitabxanada olmayan kitabı borrow etmeye cehd
            library.borrowBook("Harry Potter");
        } catch (Exception e) {
            System.out.println("Xeta: " + e.getMessage());
        }

        library.printAllBooks();
    }
}