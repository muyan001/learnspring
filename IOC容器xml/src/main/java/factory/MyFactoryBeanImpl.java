package factory;

import bean.Book;
import org.springframework.beans.factory.FactoryBean;

/**
 *
 * 实现了FactoryBean的类是spring可认识的 工厂类
 * Spring会自动的调用工厂的方法创建实例
 *
 *
 *   1、编写一个FactoryBean的实现类
 *   2、在spring的配置文件中进行注册
 *
 */

public class MyFactoryBeanImpl implements FactoryBean<Book> {

    /**
     *      getObject: 工厂方法
     *      返回创建的对象
     * @return
     * @throws Exception
     */
    public Book getObject() throws Exception {

        System.out.println("MyFactoryBeanImpl ...帮你创建对象。。。");
        Book book = new Book();
        book.setBookName("第一本数");
        return book;
    }

    /**
     *  返回创建的对象类型
     *  spring会自动调用这个方法来确认创建的 对象是什么类型
     * @return
     */

    public Class<?> getObjectType() {
        return Book.class;
    }


    /**
     *   是否是单例
     *
     *   true:是单例
     *   false:不是单例
     * @return
     */
    public boolean isSingleton() {
        return false;
    }
}
