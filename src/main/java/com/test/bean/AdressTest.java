package com.test.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class AdressTest implements BeanPostProcessor {
    public AdressTest(){
        System.out.println("AdressTest构造函数");
    }
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.contains("adressTest")) {
            System.out.println("adressTest postProcessBeforeInitialization--slh");
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.contains("adressTest")) {
            System.out.println("adressTest postProcessAfterInitialization--slh");
        }
        return bean;
    }
}
