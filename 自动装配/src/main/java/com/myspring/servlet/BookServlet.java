package com.myspring.servlet;

import com.myspring.Dao.BookDao;
import com.myspring.service.BookService;
import com.myspring.service.BookServiceExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;


/**
 *  属性的自动赋值，
 *  @Autowired: spring 会自动的为这个自定义的属性赋值，前提是一定要在容器中找到这个属性对应的组件
 */
@Controller
public class BookServlet {

    // @Qualifier : 指定一个名字作为id，让spring别使用变量名作为id
    @Qualifier("bookService")
    @Autowired(required = false)
    private BookService bookServiceExt2;
    public void doGet() throws SQLException {
        System.out.println("BookServlet....."+ bookServiceExt2);
        bookServiceExt2.save();
    }


    /**
     *  @Autowired 可以放在方法上
     *  1. 这个方法也会在bean创建的时候自动 运行
     *  2. 这个方法上的每一个参数都会自动注入值
     *
     */

    @Autowired(required = false)
    public void test(BookDao bookDao, @Qualifier("bookService") BookService bookService123){

        System.out.println("Spring 运行了这个方法。。。。。" + bookDao + "======>" + bookService123);

    }
}
