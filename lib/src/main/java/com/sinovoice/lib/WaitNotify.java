package com.sinovoice.lib;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liqiang on 2020/10/13.
 **/
public class WaitNotify {
    public  void test(){
        WaitNotify obj=new WaitNotify();
        try {
            obj.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
 class JavaThread implements Runnable {
    /**implements   extend
     * 实现线程的两种方式：
     * 1.实现runnable接口
     * 2.继承Thread类，实run方法：
     */

    private String name;
    private Object prev;
    private Object self;

    private JavaThread(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.println(name);
                    count--;
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        JavaThread pa = new JavaThread("A", c, a);
        JavaThread pb = new JavaThread("B", a, b);
        JavaThread pc = new JavaThread("C", b, c);
        new Thread(pa).start();
        Thread.sleep(100);
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Lock lock =new ReentrantLock();

        lock.lock();
        lock.unlock();
    }
}
