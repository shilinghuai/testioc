package com.test.bean;


import java.util
        .HashMap;
import java.util
        .Map;
import java.util
        .concurrent.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author shilinghuai
 * @create 2021/8/4
 * @since 1.0.0
 */
public class CountDownLatchAA {
    private static Map<String, CountDownLatch> countDownLatchMap = new HashMap();
    private static ExecutorService threadPoolExecutor = new ThreadPoolExecutor(3, 3, 2,
            TimeUnit.SECONDS, new LinkedBlockingQueue(20),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

    private static class MyThread implements Runnable {
        private String dependLatch;
        private String selfLatch;
        private String word;

        private MyThread(String dependLatch, String selfLatch, String word) {
            this.dependLatch = dependLatch;
            this.selfLatch = selfLatch;
            this.word = word;
        }

        @Override
        public void run() {
            int sum = 10;
            int parameter = 1;
            for (int i = 0; i < sum; i++) {
                try {
                    countDownLatchMap.get(dependLatch).await();
                    countDownLatchMap.put(dependLatch, new CountDownLatch(parameter));
                    System.out.print(Thread.currentThread().getId() + ":" + word + "\n");
                    countDownLatchMap.get(selfLatch).countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("a","1");
        hashMap.put("a","2");
        System.out.println(hashMap.get("a")+"-----");
        String latchA = "A";
        String latchB = "B";
        String latchC = "C";
        int parameter = 1;
        countDownLatchMap.put(latchA, new CountDownLatch(parameter));
        countDownLatchMap.put(latchB, new CountDownLatch(parameter));
        countDownLatchMap.put(latchC, new CountDownLatch(parameter));
        //latchC阻塞了latchA，先让latchC为0，则A执行
        MyThread threadA = new MyThread(latchC, latchA,latchA);
        threadPoolExecutor.execute(threadA);
        MyThread threadB = new MyThread(latchA, latchB,latchB);
        threadPoolExecutor.execute(threadB);
        MyThread threadC = new MyThread(latchB, latchC,latchC);
        threadPoolExecutor.execute(threadC);
        //调用latchC的countDown()方法，使latchA先运行
        countDownLatchMap.get(latchC).countDown();

        threadPoolExecutor.shutdown();
    }

}
