package com.sinovoice.lib.thread;

/**
 * Created by liqiang on 2020/10/26.
 **/
public class YieldTest extends Thread  {
    public YieldTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("" + this.getName() + "-----" + i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i == 30) {
                this.yield();
            }
        }
    }

    public static void main(String[] args) {
        YieldTest yt1 = new YieldTest("Tom");
        YieldTest yt2 = new YieldTest("Andy");
        yt1.start();
        yt2.start();
    }
}
