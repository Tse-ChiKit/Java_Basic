package multithreads.visibility;

import util.Tools;

public class VisibilityDemo {

    public static void main(String[] args) throws InterruptedException {
        TimeConsumingTask timeConsumingTask = new TimeConsumingTask();
        Thread thread = new Thread(new TimeConsumingTask());
        thread.start();

        // 指定的时间内任务没有执行结束的话，就将其取消
        Thread.sleep(5000);
        timeConsumingTask.cancel();
    }
}

class TimeConsumingTask implements Runnable {
    private volatile boolean toCancel = false;

    @Override
    public void run() {
        System.out.println(" run tocncel: " + toCancel);

        while (!toCancel) {
            if (doExecute()) {
                break;
            }
        }
        if (toCancel) {
            System.out.println("Task was canceled.");
        } else {
            System.out.println("Task done.");
        }
    }

    private boolean doExecute() {
        boolean isDone = false;
        System.out.println("executing...");

        // 模拟实际操作的时间消耗
        Tools.randomPause(50);
        // 省略其他代码

        return isDone;
    }

    public void cancel() {
        toCancel = true;
        System.out.println(this + " canceled.");
        System.out.println("tocncel: " + this.toCancel);

    }
}