import java.util.Scanner;

public class MainInteractive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library("Baku Book Center");

        // Kitabxana'nin oz bazasinda olan kitablar
        library.addBook(new Book("Cinayet ve Ceza", "Fyodor Dostoyevski"));
        library.addBook(new Book("Eli ve Nino", "Qurban Seid"));
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("Sefiller", "Victor Hugo"));

        int choice;
        do {
            System.out.println("\n--- Kitabxana Menyusu ---");
            System.out.println("1. Yeni kitab elave et");
            System.out.println("2. Kitab borrow et");
            System.out.println("3. Kitab qaytar");
            System.out.println("4. Butun kitabları goster");
            System.out.println("0. Cixis");
            System.out.print("Sechiminizi daxil edin: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Kitabın adını daxil edin: ");
                        String title = scanner.nextLine();
                        System.out.print("Muellifin adini daxil edin: ");
                        String author = scanner.nextLine();
                        library.addBook(new Book(title, author));
                    }
                    case 2 -> {
                        System.out.print("Borrow etmek istediyiniz kitabın adını daxil edin: ");
                        String title = scanner.nextLine();
                        library.borrowBook(title);
                    }
                    case 3 -> {
                        System.out.print("Qaytarmaq istediyiniz kitabın adini daxil edin: ");
                        String title = scanner.nextLine();
                        library.returnBook(title);
                    }
                    case 4 -> library.printAllBooks();
                    case 0 -> System.out.println("Proqramdan chixilirr...");
                    default -> System.out.println("Yanlish sechim!");
                }
            } catch (Exception e) {
                System.out.println("Xeta: " + e.getMessage());
            }

        } while (choice != 0);

        scanner.close();
    }
}
