package multithreads.visibility;

public class Test {
    public static void main(String args[]) throws InterruptedException {
        TestVolatile tv = new TestVolatile();
        new Thread(tv).start();

        Thread.sleep(1000);
        System.out.println("ending");
        tv.setRunningflag(false);
    }
}
