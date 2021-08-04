package com.test.bean;

import com.test.dao.TestMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;


import java.util
        .concurrent.ExecutorService;


import java.util
        .concurrent.Executors;

public  class User {
    private static volatile int state = 1;
    public static void main(String[] args) throws IOException {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
//        DIV userTest = (DIV) applicationContext.getBean("userTest");
//        userTest.div(1,1);
//        Parent p = new Parent();
        int count = 10;
        Object o = new Object();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new MyThread("A",o,10));
        executorService.execute(new MyThread("B",o,10));
        executorService.execute(new MyThread("C",o,10));

    }
    public static class MyThread implements Runnable{
        private String key;
        private Object lock;
        private int count = 0;
        public MyThread(){

        }
        public MyThread(String key,Object lock,int count){
            this.key = key;
            this.lock = lock;
            this.count = count;
        }

        public
        void run() {
            for(int i =0;i<10;i++){
                if("A".equals(this.key)){
                    synchronized(lock){
                        while (state!=1){

                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(i+"-->A");
                        state = 2;
                        lock.notifyAll();
                    }
                }else if("B".equals(this.key)){
                    synchronized(lock){
                        while (state!=2){

                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(i+"-->B");
                        state = 3;
                        lock.notifyAll();
                    }
                }else if("C".equals(this.key)){
                    synchronized(lock){
                        while (state!=3){

                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(i+"-->C");
                        state = 1;
                        lock.notifyAll();
                    }
                }
            }
        }
    }
}
