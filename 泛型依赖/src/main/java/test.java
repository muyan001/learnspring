import com.spring.service.BookService;
import com.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        BookService bookService = applicationContext.getBean("bookService", BookService.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);


        bookService.save();
        userService.save();


//      父类类型：class com.spring.service.BaseService
//      带泛型的父类类型：com.spring.service.BaseService<com.spring.bean.Book>
//        spring中可以使用带泛型的父类类型来确定这个子类的类型
        System.out.println(bookService.getClass().getSuperclass());
        System.out.println(bookService.getClass().getGenericSuperclass());


        /**
         *  总结：
         *  IOC是一个容器。帮我们管理所有的组件
         *  1.依赖注入。@Autowired  自动赋值
         *  2.某个组件要使用spring更多的（IOC、AOP）功能，必须加入到容器中
         *
         *  体会：
         *  1.容器启动，创建所有bean实例
         *  2、Autowired自动装配的时候，是从容器中找到那些符合要求的bean
         *  3.ioc.getbean('bookServlet');也是从容器中找到这个bean
         *  4.容器中包括了所有的bean
         *  5.调试spring的源码，容器到底是什么，其实就是一个map
         *  6.这个map保存所有创建好的bean，并提供外界获取功能
         *  7.探索，单实例bean中保存到那个map中了
         *  8.源码调试的思路：
         *          从helloworld开始，给helloword每一个关键步骤打上断点，进去看里面是怎么工作的
         *
         *              怎么知道哪些方法是干什么的
         *              1.翻译这个方法是干什么的
         *              2.放行这个方法，看控制台，看debug的每一个变量的变化
         *              3.看注释
         */

    }
}
