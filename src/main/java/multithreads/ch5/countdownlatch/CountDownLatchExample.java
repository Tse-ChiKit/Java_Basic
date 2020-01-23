package multithreads.ch5.countdownlatch;

import util.Debug;
import util.Tools;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    private static final CountDownLatch latch = new CountDownLatch(4);
    private static int data;

    public static void main(String[] args) throws InterruptedException {
        Thread workerThread = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 10; i++) {
                    data = i;
                    latch.countDown();
                    // 使当前线程暂停（随机）一段时间
                    System.out.println("in for loop: " + data);
                    Tools.randomPause(1000);
                }

            };
        };
        workerThread.start();
        latch.await();
        Debug.info("It's done. data=%d", data);
    }
}