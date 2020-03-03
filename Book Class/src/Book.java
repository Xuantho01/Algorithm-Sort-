public class Book {
    private int BookCode;
    private String name;
    private Double price;
    private String author;

    public Book(int bookCode, String name, Double price, String author) {
        BookCode = bookCode;
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public int getBookCode() {
        return BookCode;
    }

    public void setBookCode(int bookCode) {
        BookCode = bookCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "\nBook{" +
                "BookCode=" + BookCode +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
