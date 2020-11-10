package server;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class HelloWorld4 {



    public static void main(String[] args) {
        /**
         *  单实例：bean生命周期
         *          （容器启动） 构造器->初始化方法-->(容器关闭)销毁方法
         *
         *  多实例：
         *          获取bean（构造器->初始化方法-->容器关闭不会调用bean的销毁方法 ）
         *
         */


        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("IOC_jdbc.xml");

        DataSource dataSource = applicationContext.getBean("dataSource2", DataSource.class);

        System.out.println(dataSource);

    }
}
