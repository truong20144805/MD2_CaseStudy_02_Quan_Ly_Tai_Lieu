import java.io.Serializable;

public class Book implements Serializable {
    private  String id;
    private  String name;
    private  String author;
    private  String producer;
    private int page;
    private  String year;
    private  float price;

    public Book() {
    }

    public Book(String id, String name, String author, String producer, int page, String year, float price) {
        this.name = id;
        this.id = name;
        this.author = author;
        this.producer = producer;
        this.page = page;
        this.year = year;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", producer='" + producer + '\'' +
                ", page=" + page +
                ", year=" + year +
                ", price=" + price +
                '}';
    }

}

