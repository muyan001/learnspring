package server;

import bean.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class helloword2 {

    public static void main(String[] args) {


        ApplicationContext IOC = new ClassPathXmlApplicationContext("IOC2.xml");

//        Person person = IOC.getBean("person", Person.class);
//
//        Person person2 = IOC.getBean("person", Person.class);
//        System.out.println(person == person2);
//        bean.Car car = IOC.getBean("car", bean.Car.class);
//        bean.Book book = IOC.getBean("book", bean.Book.class);


//        AirPlane Staticairplane = IOC.getBean("Staticairplane", AirPlane.class);
//        System.out.println(Staticairplane);

//        AirPlane InstanceAirplane = IOC.getBean("InstanceAirplane", AirPlane.class);
//        System.out.println(InstanceAirplane);








        Book book1 = IOC.getBean("MyFactoryBeanImpl", Book.class);
        Book book2 = IOC.getBean("MyFactoryBeanImpl", Book.class);
        System.out.println(book1 == book2);


    }
}
