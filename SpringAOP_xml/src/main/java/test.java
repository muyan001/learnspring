import com.spring.impl.Calculator;
import com.spring.inter.MyMathCalculator;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

public class test {

    public static void main(String[] args) {

//        MyMathCalculator calculator = new MyMathCalculator();
//
//        calculator.add(1,2);
//
//
//        System.out.println("==================================");
//
//        // 如果是拿到了这个对象 的代理对象，代理对象执行加减乘除；
//        Calculator  proxy = CalculatorProxy.getProxy(calculator);
//
////        proxy.div(2,1);
//
//
//        proxy.add(2,3);

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        /**
         * 1.从IOC容器中拿到目标对象，注意：如果想用类型，一定要用他的接口类型，不要用他的本类
         *
         * 细节一：
         * com.spring.inter.MyMathCalculator@40a4337a
         * class com.sun.proxy.$Proxy16
         *
         * AOP底层就是动态代理，容器中保存的组件是他的代理对象：$Proxy16 ，这个类型当然不是本类类型
         */

//        Calculator bean = applicationContext.getBean(Calculator.class);
        /**
         *  代理对象和实例对象没有关联，唯一的关联是他们都继承了同一个接口，所以获取实例的时候，必须要写接口类型
         */
//        bean.add(1,13);
//        System.out.println(bean);
//        System.out.println(bean.getClass());
//
//        Calculator bean1 = (Calculator) applicationContext.getBean("myMathCalculator");
//        bean1.div(5,1);

        /**
         *  没有继承接口getbean就是本类类型
         *  class com.spring.inter.MyMathCalculator$$EnhancerBySpringCGLIB$$1b112cd7
         *  cglib帮我们创建好的代理对象
         */

        MyMathCalculator calculator = applicationContext.getBean("myMathCalculator",MyMathCalculator.class);
        int re = calculator.add(1,2);
//        System.out.println(calculator.getClass());

        System.out.println("====================================");
//        calculator.div(1,0);


        /**
         *
         *
         *  细节三：通知方法的执行顺序
         *
         *
         *      try{
         *
         *             @Before
         *          method.invoke(obj,arges)
         *          @AfterReturning
         *
         *      }catch(){
         *       @AfterThrowing
         *      }finally{
         *         @After
         *      }
         *
         *      正常执行：
         *              @Before（前置通知）-->@After(后置通知)-->@AfterReturning(正常返回)
         *
         *      异常执行：
         *              @Before（前置通知）-->@After(后置通知)-->@AfterThrowing(异常返回)
         */

    }
}
