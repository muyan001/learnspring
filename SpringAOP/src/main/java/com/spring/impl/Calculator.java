package com.spring.impl;

import org.springframework.stereotype.Service;


/**
 *  接口也不应该加载到容器中， 实际上可以加，加了也不创建对象
 *  只要一个组件是一个接口，相当于告诉spring，ioc容器中可能有这种类型的组件
 */
public interface Calculator {
    public int add(int i ,int j);
    public int sub(int i ,int j);
    public int mul(int i ,int j);
    public int div(int i ,int j);
}
