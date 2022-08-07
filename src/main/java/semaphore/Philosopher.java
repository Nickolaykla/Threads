package semaphore;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {
    private Semaphore sem;
    private String name;
    private boolean isFull = false;

    public Philosopher(Semaphore sem, String name) {
        this.sem = sem;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            if (!isFull) {
                sem.acquire();
                System.out.println("Философ " + name + " садится за стол");
                Thread.sleep(1000);
                isFull = true;

                System.out.println("Философ " + name + " встает из-за стола");
                Thread.sleep(1000);
                sem.release();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
