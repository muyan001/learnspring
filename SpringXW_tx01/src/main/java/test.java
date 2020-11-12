import com.learn.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        BookService bookService = applicationContext.getBean(BookService.class);

        bookService.checkout("Tom","ISBN-001");
        System.out.println("结账完成");

    }
}
