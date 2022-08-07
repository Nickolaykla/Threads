package executor;

import java.util.concurrent.CountDownLatch;

public class MyThread implements Runnable {
    CountDownLatch cdl;
    String name;

    public MyThread(CountDownLatch cdl, String name) {
        this.cdl = cdl;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            cdl.countDown();
        }
    }
}
