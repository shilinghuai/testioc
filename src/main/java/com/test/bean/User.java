package com.test.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        DIV userTest = (DIV) applicationContext.getBean("userTest");
        userTest.div(1,1);
        Parent p = new Parent();
//        Child c = (Child) p;
//        c.sayhello2();
//        IIopImpl iIopImpl2 = new IIopImpl();
//        IIop2 iIop =  iIopImpl2;
//        IIop iIop1 = iIopImpl2;
    }

}
