package com.hellojd.samples.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2016/11/20.
 */
public class StartThreadDemo {
    /**
     * 第一种创建线程的方式直接 extends Thread 覆盖run()方法即可；
     */
    static class ThreadA extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                // TODO Auto-generated method stub
                //模拟做事情执行了500毫秒；
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("这是线程 A");
        }
    }
    //implements Runnable接口，实现run()方法；
    //有点，java里面可以有多个接口，解决extends的缺点
    static class RunnableTaskB implements Runnable {
        @Override
        public void run() {
            try {
                //模拟做事情执行了500毫秒；
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这是线程 B");
        }
    }

    //implements Callable接口，实现call()方法；
    //可有有返回结果，注意这次是要覆盖call方法；
    static class CallableTaskC implements Callable<String> {
        @Override
        public String call() throws Exception {
            try {
                //模拟做事情执行了500毫秒；
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这是线程 C");
            return "thread C";
        }
    }

    public static void main(String[] args) {
        ThreadA threada = new ThreadA();
        threada.start();
        RunnableTaskB threadb = new RunnableTaskB();
        new Thread(threadb).start();//注意启动方式有点不一样；
        System.out.println("这是主线程；");

        CallableTaskC threadc = new CallableTaskC();
        FutureTask<String> feature = new FutureTask<String>(threadc);
        new Thread(feature).start();//注意启动方式有点不一样；
        System.out.println("这是主线程；begin！");
        try {
            System.out.println("得到的返回结果是："+feature.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
