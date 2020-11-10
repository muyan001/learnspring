package server;

import bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class autowire {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext01.xml");

        Person person = context.getBean("person", Person.class);
//        System.out.println(person);

        Person person2 = context.getBean("person2", Person.class);
        System.out.println(person2);
    }
}
