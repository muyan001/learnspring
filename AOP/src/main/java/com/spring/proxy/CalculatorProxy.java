package com.spring.proxy;

import com.spring.impl.Calculator;
import com.spring.inter.MyMathCalculator;
import com.spring.util.LogUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

//

/**
 *
 * 帮Calculator.java生成代理对象的类
 *
 */
public class CalculatorProxy {

    /**
     *  为传入的参数对象创建一个动态的代理对象
     * @param calculator
     * @return
     *
     * Calculator calculator：被代理对象
     * 返回的是代理对象
     */

    // 返回值必须是一个接口的类型
    public static Calculator getProxy(final MyMathCalculator calculator){

//        方法执行器
        InvocationHandler h = new InvocationHandler() {
            /**
             *
             * @param proxy :代理对象，给jdk使用，任何时候都不要动
             * @param method：当前将要执行目标的方法
             * @param args :这个方法调用是外界传入的参数值
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                
                Object result = null;
                try {

                    LogUtil.before(method,args);

                    System.out.println("这是动态代理将要帮你执行的方法。。。。");
                    // 利用反射执行方法
//                 目标方法执行后的返回值
                     result = method.invoke(calculator, args);


                    LogUtil.afterRunning(method,result);
                    
                }catch (Exception e){

                   LogUtil.afterExpection(method,e);
                    
                }finally {

                    System.out.println(method.getName() + "方法无论如何都要执行的地方");

//                返回值必须返回出去外界才能拿到真正执行后的返回值
                    return result;
                }

            }
        };
        Class[] interfaces =calculator.getClass().getInterfaces();
        ClassLoader loader = calculator.getClass().getClassLoader();
        //Proxy 为目标对象创建代理对象
        Object proxy = Proxy.newProxyInstance(loader,interfaces,h);
        return (Calculator) proxy;
    }
}
