class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public void borrowBook() throws BookAlreadyBorrowedException {
        if (isBorrowed) {
            throw new BookAlreadyBorrowedException("Kitab artiq borrow olunub: " + title);
        }
        isBorrowed = true;
        System.out.println("Kitab borrow edildi: " + title);
    }

    public void returnBook() throws BookNotBorrowedException {
        if (!isBorrowed) {
            throw new BookNotBorrowedException("Kitab borrow olunmayib: " + title);
        }
        isBorrowed = false;
        System.out.println("Kitab qaytarildi: " + title);
    }

    public void printInfo() {
        System.out.println("Bashliq: " + title + " | Muellif: " + author +
                " | Status: " + (isBorrowed ? "Borrow olunub" : "Movcuddur"));
    }
}