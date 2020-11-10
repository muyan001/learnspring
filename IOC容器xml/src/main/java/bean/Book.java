package bean;

public class Book {

    private String bookName;
    private Integer price;
    private String author;

    public void myInit(){
        System.out.println("这是图书的初始化方法。。。");
    }

    public void myDestory(){
        System.out.println("这是图书的销毁方法。。。。");
    }

    public Book() {
        super();
        System.out.println("Book的无参构造被创建");
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
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
        return "bean.Book{" +
                "bookName='" + bookName + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
