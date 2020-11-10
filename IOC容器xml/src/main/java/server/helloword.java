package server;

import bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class helloword {


    /**
     *  从容器中拿到这个组件
     * @param args
     */

    public static void main(String[] args) {

        /**
         *  ApplicationContext:代表IOC容器
         *  ClassPathXmlApplicationContext: 代表应用的xml文件在classPath目录下，将其放在resource文件夹下面
         *  根据Spring配置文件得到IOC容器对象
         */
//        ApplicationContext ioc  = new ClassPathXmlApplicationContext("conf.xml");
//        bean.Person firstperson = (bean.Person) ioc.getBean("firstperson");
//        bean.Person person2 = ioc.getBean("person2", bean.Person.class);
//        bean.Person person3 = ioc.getBean("person3", bean.Person.class);
//        System.out.println(firstperson.toString());
//        System.out.println(person2.toString());
//        System.out.println(person3.toString());

        ApplicationContext IOC = new ClassPathXmlApplicationContext("IOC.xml");
        Person person01 = IOC.getBean("person01", Person.class);
        System.out.println(person01);


        Person person02 = IOC.getBean("person02", Person.class);
        System.out.println(person02);


        Person fuhao = IOC.getBean("fuhao", Person.class);
        System.out.println(fuhao);

        Person fuhao02 = IOC.getBean("fuhao02", Person.class);
        System.out.println(fuhao02);

        Person person03 = IOC.getBean("person03", Person.class);
        System.out.println(person03);


        Person person04 = IOC.getBean("person04", Person.class);
        System.out.println(person04);
        System.out.println(person04.getProperties());

        Person person11 = IOC.getBean("person11", Person.class);
        System.out.println(person11);
//        System.out.println(person04.getProperties());

        Map<String,Object> mymap = (Map<String, Object>) IOC.getBean("mymap", Map.class);
        System.out.println(mymap);


        Person person55 = IOC.getBean("person55", Person.class);
        System.out.println(person55);

        Person person22 = IOC.getBean("person22", Person.class);
        System.out.println(person22);

        Person person33 = IOC.getBean("person33", Person.class);
        System.out.println(person33);





    }
}
