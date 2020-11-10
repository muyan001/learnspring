package com.spring.inter;

import com.spring.impl.Calculator;
import org.springframework.stereotype.Service;

@Service
public class MyMathCalculator /*implements Calculator */{
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("加法内部执行");
        return result;
    }

    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("减法内部执行");
        return result;
    }

    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("乘法内部执行");
        return result;
    }

    public int div(int i, int j) {
        int result = i / j;
        System.out.println("除法内部执行");
        return result;
    }
}
