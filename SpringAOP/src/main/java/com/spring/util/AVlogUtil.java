package com.spring.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(2)
public class AVlogUtil {

    @Before(value = "execution(public int com.spring.inter.MyMathCalculator.*(int ,int ))")
    public void myBefore(JoinPoint joinPoint){

        Object[] args = joinPoint.getArgs();

        String name = joinPoint.getSignature().getName();
        System.out.println( "VlogUtil=="+name + "方法执行之前，参数为："+ Arrays.asList(args));
    }

    @AfterReturning(value = "execution(public int com.spring.inter.MyMathCalculator.*(int ,int ))",returning = "result")
    public void myAfterReturning(JoinPoint joinPoint,Object result){

        String name = joinPoint.getSignature().getName();
        System.out.println("VlogUtil=="+name + " 方法执行之后，结果为：" + result);
    }
    @AfterThrowing(value = "execution(public int com.spring.inter.MyMathCalculator.*(int ,int ))",throwing = "exception")
    public void myAfterThrowing(JoinPoint joinPoint,Exception exception){

        String name = joinPoint.getSignature().getName();

        System.out.println("VlogUtil=="+name +  "方法执行后产生异常，异常信息为 " + exception);
    }

    @After(value = "execution(public int com.spring.inter.MyMathCalculator.*(int ,int ))")
    public void myAfter(JoinPoint joinPoint){

        String name = joinPoint.getSignature().getName();
        System.out.println("VlogUtil=="+name +"方法完全执行后");

    }
}
