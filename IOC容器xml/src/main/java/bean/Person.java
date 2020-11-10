package bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {

    private String name;
    private Integer age;
    private String addr;
    private Integer phone;
    private Car car;
    private List<Book> books;
    private Map<String,Object> maps;
    private Properties properties;


    public Person(Car car) {
        this.car = car;
        System.out.println("可以为Car赋值的有参构造器");
    }

    public Person() {
        System.out.println("Person无参构造器被创建。。。。");
    }

    public Person(String name, Integer age, Integer phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;

        System.out.println("有参构造器被创建。。。。");
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "bean.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", car=" + car +
                ", books=" + books +
                ", maps=" + maps +
                ", properties=" + properties +
                '}';
    }
}
