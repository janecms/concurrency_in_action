package com.hellojd.samples.base;

/**
 * Created by Administrator on 2016/11/20.
 */
public class SuspendResumeDeadLock {
    static class SynchronizedObject {
        synchronized public void printString() {
            System.out.println(Thread.currentThread().getName()+"==>begin");
            if (Thread.currentThread().getName().equals("a")) {
                System.out.println("a线程永远suspend了");
                Thread.currentThread().suspend();
            }
            System.out.println(Thread.currentThread().getName()+"==>end");
        }
    }

    public static void main(String[] args) {
        try {
            final SynchronizedObject object = new SynchronizedObject();

            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    object.printString();
                }
            };

            thread1.setName("a");
            thread1.start();

            Thread.sleep(1000);

            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    System.out .println("thread2启动了，但进入不了printString()，只打印一个begin");
                    object.printString();
                }
            };
            thread2.setName("b");
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
