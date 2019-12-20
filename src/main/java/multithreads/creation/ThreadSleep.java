package multithreads.creation;

import sun.jvm.hotspot.runtime.Threads;

public class ThreadSleep {

    Thread t;

    public void doSleep() {
        System.out.println("hello: " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
            System.out.println("my");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("world");
    }

    public void createthread(int num) {
        for (int i = 0; i < num; i++) {
            t = new Mythread();
            t.setName("eric " + i);
            t.start();
        }
    }


    class Mythread extends Thread {
        @Override
        public void run() {
            doSleep();
        }
    }


    public static void main(String[] args) {

        ThreadSleep ts = new ThreadSleep();
        ts.createthread(3);
    }

}
