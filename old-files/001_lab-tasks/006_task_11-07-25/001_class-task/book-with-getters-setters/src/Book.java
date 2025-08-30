
public class Book {

    private String name;
    private String author;
    private int pageCount;

    public Book(String name, String author, int pageCount) {
        this.name = name;
        this.author = author;
        this.pageCount = pageCount;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
