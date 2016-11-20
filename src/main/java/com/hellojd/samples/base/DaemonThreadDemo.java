package com.hellojd.samples.base;

/**
 * Created by Administrator on 2016/11/20.
 */
public class DaemonThreadDemo {
    /**
     * 如果所有线程执行完毕，守护线程立刻停止
     */
    static class ThreadA extends Thread {
        public void run() {
            for (long i = 0; i < 9999999L; i++) {
                System.out.println("后台线程A第" + i + "次执行！");
                try {
                    Thread.sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadB extends Thread{
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("线程B第" + i + "次执行！");
                try {
                    Thread.sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread tA = new ThreadA();
        Thread tB = new ThreadB();
        tA.setDaemon(true); // 设置为守护线程,注意一定要在开始之前调用
        tB.start();
        tA.start();
        Thread mainThread = Thread.currentThread();
        System.out.println("线程A是不是守护线程：" + tA.isDaemon());
        System.out.println("线程b是不是守护线程：" + tB.isDaemon());
        System.out.println("线程main是不是守护线程：" + mainThread.isDaemon());
    }

}
