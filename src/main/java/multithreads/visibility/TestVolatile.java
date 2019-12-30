package multithreads.visibility;

public class TestVolatile implements Runnable {
    private boolean isRunningflag = true;

    public void setRunningflag(boolean runflag) {
        this.isRunningflag = runflag;
    }

    @Override
    public void run() {
        while (isRunningflag == true) {
            System.out.println("Running");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
