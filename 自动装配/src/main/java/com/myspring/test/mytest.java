package com.myspring.test;

import com.myspring.Dao.BookDao;
import com.myspring.servlet.BookServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class mytest {
    public static void main(String[] args) throws SQLException {

        /**
         *
         *  使用注解加入到容器中的组件，和使用配置 加入到容器中的组件的行为都是一样的
         *  1.组件的id，默认就是组件的类名首字母小写
         *      更改组件id====   @Repository("bookdao1")
         *  2.组件的作用域默认为单例
         *          改变为多实例：@Scope(value = "prototype")
         */

        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

//        Object bookDao = context.getBean("bookDao");
//        BookDao bookDao1 = context.getBean("bookDao", BookDao.class);

        BookServlet booServlet = context.getBean("bookServlet", BookServlet.class);
        booServlet.doGet();

    }
}
