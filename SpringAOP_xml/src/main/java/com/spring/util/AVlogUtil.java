package com.spring.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


public class AVlogUtil {


    public void myBefore(JoinPoint joinPoint){

        Object[] args = joinPoint.getArgs();

        String name = joinPoint.getSignature().getName();
        System.out.println( "VlogUtil=="+name + "方法执行之前，参数为："+ Arrays.asList(args));
    }


    public void myAfterReturning(JoinPoint joinPoint,Object result){

        String name = joinPoint.getSignature().getName();
        System.out.println("VlogUtil=="+name + " 方法执行之后，结果为：" + result);
    }

    public void myAfterThrowing(JoinPoint joinPoint,Exception exception){

        String name = joinPoint.getSignature().getName();

        System.out.println("VlogUtil=="+name +  "方法执行后产生异常，异常信息为 " + exception);
    }


    public void myAfter(JoinPoint joinPoint){

        String name = joinPoint.getSignature().getName();
        System.out.println("VlogUtil=="+name +"方法完全执行后");

    }
}
