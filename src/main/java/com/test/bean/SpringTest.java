//package com.test.bean;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SpringTest implements BeanPostProcessor {
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        if (beanName.contains("testInitOrder")) {
//            System.out.println("TestInitOrder postProcessBeforeInitialization--slh");
//        }
//        return bean;
//    }
//
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        if (beanName.contains("testInitOrder")) {
//            System.out.println("TestInitOrder postProcessAfterInitialization--slh");
//        }
//        return bean;
//    }
//
//}
