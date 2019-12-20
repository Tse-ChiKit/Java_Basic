package multithreads.creation;

import util.Tools;

public class ThreadCreationCmp {


    final int numberOfProceesors = Runtime.getRuntime().availableProcessors();


    public void executeWithRunnable() {

        Thread t;
        CountingTask countingTask = new CountingTask();

        System.out.println("number of cpus: " + numberOfProceesors);

        for (int i = 0; i < numberOfProceesors; i++) {
            t = new Thread(countingTask);
            t.start();
        }
    }

    public void executeWithThread() {

        Thread t;
        System.out.println("number of cpus: " + numberOfProceesors);

        for (int i = 0; i < numberOfProceesors; i++) {
            t = new CountingThread();
            t.start();
        }
    }

    static class Counter {
        private int count = 0;

        public void increment() {
            count++;
        }

        public int value() {
            return count;
        }
    }

    static class CountingTask implements Runnable {
        private Counter counter = new Counter();

        @Override
        public void run() {

            for (int i = 0; i < 100; i++) {
                System.out.println("Thread name " + Thread.currentThread().getName());

                doSomething();
                counter.increment();
                System.out.println("CountingTask: " + counter.value());
            }
        }

        private void doSomething() {
            Tools.randomPause(80);
        }
    }

    static class CountingThread extends Thread {
        private Counter counter = new Counter();

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread name " + Thread.currentThread().getName());

                doSomething();
                counter.increment();
                System.out.println("CountingTask: " + counter.value());
            }
        }

        private void doSomething() {
            Tools.randomPause(80);
        }

    }

    public static void main(String[] args) {

        ThreadCreationCmp tcc = new ThreadCreationCmp();
        tcc.executeWithThread(); // less than 800 -> work on shared runnable instance
        tcc.executeWithRunnable(); // equals 800 -> 100 * 8
    }

}
