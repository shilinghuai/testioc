package com.test.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class UserTest implements DIV{
    public UserTest(){
        System.out.println("usertest构造函数");
    }
    public int div(int i,int j){
        System.out.println("MathCalculator...div...");
        return i/j;
    }
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("beanname"+beanName);
            System.out.println("userTest postProcessBeforeInitialization--slh");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("beanname"+beanName);

        System.out.println("userTest postProcessAfterInitialization--slh");
        return bean;
    }
    public static class MyInner{
        int ia = 10;
    }
}
