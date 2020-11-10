package com.spring.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;


public class LogUtil {


    /**
     *  告诉spring每个方法都在什么时候运行
     *
     *  try{
     *       @Before
     *      method.invoke(obj,args)
     *      @AfterReturning
     *  }catch(e){
     *          @AfterThrowing
     *  }finally{
     *      @After()
     *  }
     *
     *   5个通知注解
     *
     *  @Before             在目标方法之前运行            前置通知
     *  @After()            在目标方法结束之后            后置通知
     *  @AfterReturning    在目标方法正常放回之后          返回通知
     *  @AfterThrowing    在目标方法抛出异常之后           异常通知
     *
     *  @Around()   环绕                                  环绕通知
     *
     *
     */

    /**
     *
     *   细节二：
     *
     *  切入点表达式的写法：
     *  固定格式：execution(访问权限符  返回值类型  方法全类名（参数表）)
     *
     *  通配符：
     *         *：1.匹配一个或者多个 execution(public int com.spring.inter.MyMath*r.*(int,int))
     *             2.匹配任意一个参数  ：
     *               第一个参数是int，第二个参数任意类型（匹配两个参数）
     *              execution(public int com.spring.inter.MyMathCalculator.*(int,*))
     *             3、只能匹配一层路径：【在路径上放到第一位代表任意层】
     *              execution(public int com.spring.*.MyMathCalculator.*(int,int))
     *             4. 权限位置不能写* ， 权限位置不写就代表任意  ,public【可选的】
     *
     *         .. :
     *              1.匹配任意多个参数，任意类型参数
     *              2.匹配任意多层路径
     *
     *                 execution(public int com.spring..MyMathCalculator.*(int,int))
     *
     *
     *    记住两种：
     *          最精确的： execution(public int com.spring.inter.MyMathCalculator.add(int,int))
     *          最模糊的：execution( * *.*(..)):;;;千万别写
     *
     *
     *
     *     抽取可重用的切入点表达式：(此环节jar包版本低，不能实现)
     *     1、随便申明一个没有实现的void方法
     *     2、给方法标注上 @Pointcut注解
     *
     *
     *
     */




    public static void before(JoinPoint joinPoint){
        // 获取到目标方法运行时的参数
        Object[] args = joinPoint.getArgs();

        // 获取方法的签名
        Signature signature = joinPoint.getSignature();

        String name = signature.getName();
        System.out.println( "LogUtil------>"+name + "方法执行之前，参数为："+Arrays.asList(args));

//        System.out.println(method.getName()+"方法执行之前，参数为：" + Arrays.asList(args));
    }



    public static void afterRunning(JoinPoint joinPoint,Object result){

        // 获取方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();

        System.out.println( "LogUtil------>"+name + " 方法执行之后，结果为：" + result);
//        System.out.println(method.getName()+"方法执行之后，结果为：" + result);
    }



    public static void  afterExpection(JoinPoint joinPoint,Exception exception ){
        // 获取方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();

        System.out.println( "LogUtil------>"+name +  "方法执行后产生异常，异常信息为 " + exception);
//        System.out.println(method.getName()+ "方法执行后产生异常，异常信息为"+ e.getCause());

       
    }






    public  static void after(JoinPoint joinPoint){

        // 获取方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();

        System.out.println( "LogUtil------>"+name +"方法完全执行后");
    }





    public Object myAround(ProceedingJoinPoint joinPoint){

        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        // 就是利用反射推进执行目标方法,就是method.invoke(obj,args)
        Object proceed = null;
        try {
            // 相当于@befor
            System.out.println("【环绕前置通知】【"+name +"】方法开始执行，参数为："+Arrays.asList(args));
             proceed = joinPoint.proceed();
            //相当于@AfterReturning
            System.out.println("【环绕的返回通知】【"+name+"】方法返回，返回值："+proceed);
        } catch (Throwable throwable) {
            //相当于@AfterThrowing
            System.out.println("【环绕异常通知】【"+name+"】方法异常，异常信息："+throwable);
            throwable.printStackTrace();
        }finally {
            //相当于@After()
            System.out.println("【环绕后置通知】【"+name +"】方法结束");
        }

        // 反射调用后的返回值也一定要返回出去
        return proceed;
    }







}
