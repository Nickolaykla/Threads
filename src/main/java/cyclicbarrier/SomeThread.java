package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SomeThread implements Runnable {
    CyclicBarrier cb;
    String name;

    public SomeThread(CyclicBarrier cb, String name) {
        this.cb = cb;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
        try {
            cb.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
