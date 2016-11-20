package com.hellojd.samples.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/11/20.
 */
public class ExceptionThreadDemo {
    static class Task1 implements Runnable {
        public void run() {
            for(int i=0;i<10;i++){
                int number0 = Integer.parseInt("TTT");
            }
        }
    }
    static class Task2 implements Runnable {
        public void run() {
            for(int i=0;i<10;i++){
                int number0 = Integer.parseInt("SSS");
            }
        }
    }
    public static void main(String[] args) {
        Task1 task = new Task1();
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        thread.start();

    }
}
