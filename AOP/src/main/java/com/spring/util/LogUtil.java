package com.spring.util;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LogUtil {


    public static void before(Method method,Object[] args){

        System.out.println(method.getName()+"方法执行之前，参数为：" + args );
    }


    public static void afterRunning(Method method,Object result){
        System.out.println(method.getName()+"方法执行之后，结果为：" + result);
    }

    public static void  afterExpection(Method method,Exception e){
        System.out.println(method.getName()+ "方法执行后产生异常，异常信息为"+ e.getCause());
       
    }







}
