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
/**
 *  代理对象和实例对象没有关联，唯一的关联是他们都继承了同一个接口，
 */

/**
 *  如何将这个类（切面类）中的这些方法（通知方法）动态的  在目标方法的各个位置切入
 */

@Aspect
@Component
@Order(1) //aop切面顺序用的，默认值为int的最大值，值越小，排名越靠前
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

    @Pointcut(value = "execution(public int com.spring.inter.MyMathCalculator.*(..))")
    public void testhaha(){

    }




//    @Around()
//    @AfterThrowing
//    @AfterReturning
//    @After()
//    @Before()
//    想在目标方法执行之前运行，写切入点表达式(写法：excution（访问权限符 返回值类型 方法签名))


    @Before("execution(public int com.spring.inter.MyMathCalculator.*(int,int))")
//    @Before("testhaha()")
    public static void before(JoinPoint joinPoint){
        // 获取到目标方法运行时的参数
        Object[] args = joinPoint.getArgs();

        // 获取方法的签名
        Signature signature = joinPoint.getSignature();

        String name = signature.getName();
        System.out.println( "LogUtil------>"+name + "方法执行之前，参数为："+Arrays.asList(args));

//        System.out.println(method.getName()+"方法执行之前，参数为：" + Arrays.asList(args));
    }


    @AfterReturning(value = "execution(public int com.spring.inter.MyMathCalculator.*(int ,int ))",returning = "result")
//    @AfterReturning(value = "testhaha()",returning = "result")
    public static void afterRunning(JoinPoint joinPoint,Object result){

        // 获取方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();

        System.out.println( "LogUtil------>"+name + " 方法执行之后，结果为：" + result);
//        System.out.println(method.getName()+"方法执行之后，结果为：" + result);
    }


    /**
     *
     *   拿到异常信息:
     *   throwing = "result" :告诉spring，用result来接异常信息
     *
     *   value = "execution(public int com.spring.inter.MyMathCalculator.*(int ,int))",throwing = "result"
     *
     */

    /**
     *  细节四：
     *          我们可以在通知方法运行的时候，拿到目标方法的详细信息
     *          1.只需要我们为通知方法的参数列表上写一个参数
     *              JoinPoint joinPoint: 封装了当前目标方法的详细信息
     *          2.告诉spring哪个参数用来接收异常（返回值），throwing = "result" :告诉spring，用result来接异常信息
     *          3.Exception exception、Object result :指定spring 通知方法可以接受那些异常，往大了写
     */

    @AfterThrowing(value = "execution(public int com.spring.inter.MyMathCalculator.*(int ,int))",throwing = "exception")
//    @AfterThrowing(value = "testhaha()",throwing = "exception")
    public static void  afterExpection(JoinPoint joinPoint,Exception exception ){
        // 获取方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();

        System.out.println( "LogUtil------>"+name +  "方法执行后产生异常，异常信息为 " + exception);
//        System.out.println(method.getName()+ "方法执行后产生异常，异常信息为"+ e.getCause());

       
    }





    @After("execution(public int com.spring.inter.MyMathCalculator.*(int ,int))")
//    @After(value = "testhaha()")
    public  static void after(JoinPoint joinPoint){

        // 获取方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();

        System.out.println( "LogUtil------>"+name +"方法完全执行后");
    }


    /**
     *
     *  细节五：环绕通知
     *      @Around() ：是spring中最强大的通知，其实就是动态代理
     *
     *      try{
     *          //前置通知
     *          method.invoke(obj,args)
     *          //返回通知
     *      }catch(){
     *          // 异常通知
     *      }finally{
     *          // 后置通知
     *      }
     *      这四个通知合起来就是环绕通知
     *
     *      环绕通知中有一个参数ProceedingJoinPoint joinPoint
     *
     *
     *  环绕通知是优先于普通通知执行，执行顺序：
     *
     *      【普通前置】
     *      {
     *
     *          try{
     *              环绕的前置
     *
     *              环绕执行：目标方法执行
     *
     *              环绕的返回
     *          }catch(){
     *              环绕的异常
     *          }finally{
     *              环绕的后置
     *          }
     *      }
     *      目标方法执行
     *      【普通后置】
     *      【普通方法返回或者方法异常】
     *
     *
     *
     *      新的顺序：
     *        环绕前置-->普通前置-->目标方法执行-->环绕正常返回/异常-->环绕后置-->普通后置-->普通返回/异常
     *
     */

    @Around(value = "execution(public int com.spring.inter.MyMathCalculator.*(int,int))")
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
