package com.hellojd.samples.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/20.
 */
public class StopThreadDemo {
    static class Task implements  Runnable{
        private long i=0;
        public void setI(long i){this.i=i;}
        public long getI(){return this.i;}
        @Override
        public void run() {
            while(true){
                i++;
            }
        }
    }

    public static void main(String[] args) {
        try {
            Task t = new Task();
            Thread thread = new Thread(t);
            thread.start();
            Thread.sleep(5000);
            thread.suspend();//暂停
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            System.out.println(df.format(new Date()) + "i=" + t.getI());
            Thread.sleep(5000);
            System.out.println(df.format(new Date()) + "i=" + t.getI());
            System.out.println("-----------------------------");

            thread.resume();//恢复
            Thread.sleep(5000);
            thread.suspend();//暂停
            System.out.println(df.format(new Date()) + "i=" + t.getI());
            Thread.sleep(5000);
            System.out.println(df.format(new Date()) + "i=" + t.getI());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
