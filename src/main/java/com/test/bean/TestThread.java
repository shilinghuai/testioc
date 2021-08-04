package com.test.bean;

public class TestThread extends Thread {
    public  static TestThread ia = new TestThread();
    public void run(){
        synchronized(ia){
            System.out.println("---test");

            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----test111");
        }

    }
}
