package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class SomeThread implements Runnable {
    CountDownLatch latch;

    public SomeThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            latch.countDown();
        }
    }
}
