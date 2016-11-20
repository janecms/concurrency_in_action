package com.hellojd.samples.base;

/**
 * Created by Administrator on 2016/11/20.
 */
public class AliveThreadDemo {
    static class AliveThread extends Thread{
        public  AliveThread(){
            System.out.println("AliveThread constract start--");
            System.out.println("this==Thread.currentThread() >" + (this==Thread.currentThread()));
            System.out.println("this.isAlive()==>" + this.isAlive());
            System.out.println("Thread.currentThread().isAlive()==>" + Thread.currentThread().isAlive());
            System.out.println("AliveThread constract end --");
            System.out.println("\n\n");
        }
        public void run(){
            System.out.println("AliveThread run start--");
            System.out.println("this==Thread.currentThread() >" + (this==Thread.currentThread()));//启动方式有差异，造成结果差异
            System.out.println("this.isAlive()==>" + this.isAlive());
            System.out.println("Thread.currentThread().isAlive()==>" + Thread.currentThread().isAlive());
            System.out.println("AliveThread run end --");
        }
    }

    public static void main(String[] args) {
        new AliveThread().start();

        Thread t1 = new Thread(new AliveThread());
        t1.setName("AliveThread");
        t1.start();
    }
}
