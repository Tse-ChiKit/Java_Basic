package multithreads.race;

import util.Tools;

public class RaceConditionDemo {
    public static void main(String[] args) throws Exception {
        int numberOfThreads = args.length > 0 ? Short.valueOf(args[0]) : Runtime.getRuntime().availableProcessors();
        Thread[] workerThreads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            workerThreads[i] = new WorkerThread(i, 10);
        }

        for (Thread ct : workerThreads) {
            ct.start();
        }
    }


    // 模拟业务线程
    static class WorkerThread extends Thread {
        private final int requestCount;

        public WorkerThread(int id, int requestCount) {
            super("worker-" + id);
            this.requestCount = requestCount;
        }

        @Override
        public void run() {
            System.out.println("running");
            int i = requestCount;
            String requestID;
            RequestIDGenerator requestIDGen = RequestIDGenerator.getInstance();
            while (i-- > 0) {
                // 生成Request ID
                requestID = requestIDGen.nextID();
                processRequest(requestID);
            }
        }

        // 模拟请求处理
        private void processRequest(String requestID) {
            // 模拟请求处理耗时
            Tools.randomPause(50);
            System.out.printf("%s got requestID: %s %n",
                    Thread.currentThread().getName(), requestID);
        }
    }
}
