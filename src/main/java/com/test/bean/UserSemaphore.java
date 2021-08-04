package com.test.bean;


import java.io
        .IOException;
import java.util
        .concurrent.ExecutorService;
import java.util
        .concurrent.Executors;


import java.util
        .concurrent.Semaphore;


public  class UserSemaphore {
    private static volatile int state = 1;
    public static void main(String[] args) throws IOException {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
//        DIV userTest = (DIV) applicationContext.getBean("userTest");
//        userTest.div(1,1);
//        Parent p = new Parent();
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new MyThread(semaphoreA,semaphoreB,"A"));
        executorService.execute(new MyThread(semaphoreB,semaphoreC,"B"));
        executorService.execute(new MyThread(semaphoreC,semaphoreA,"C"));

    }
    public static class MyThread implements Runnable{
        private  Semaphore currentSema;
        private Semaphore nextSema;
        private String key;
        public MyThread(){

        }
        public MyThread(Semaphore currentSema, Semaphore nextSema,String key){
            this.currentSema = currentSema;
            this.nextSema = nextSema;
            this.key = key;
        }

        public
        void run() {
            for (int i=0;i<10;i++){

                try {
                    currentSema.acquire();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i+"->"+this.key);
                nextSema.release();
            }
        }
    }
}
