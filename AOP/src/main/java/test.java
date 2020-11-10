import com.spring.impl.Calculator;
import com.spring.inter.MyMathCalculator;
import com.spring.proxy.CalculatorProxy;

import java.lang.reflect.Proxy;

public class test {

    public static void main(String[] args) {

        MyMathCalculator calculator = new MyMathCalculator();

        calculator.add(1,2);


        System.out.println("==================================");

        // 如果是拿到了这个对象 的代理对象，代理对象执行加减乘除；
        Calculator  proxy = CalculatorProxy.getProxy(calculator);

//        proxy.div(2,1);


        proxy.add(2,3);






    }
}
