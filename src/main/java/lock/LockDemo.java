package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(new Increment(lock)).start();
        new Thread(new Decrement(lock)).start();
    }

}
class Resource {
    static int i = 0;
}
class Increment implements Runnable {
    Lock lock;

    public Increment(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("Start Increment Thread");
        lock.lock();
        for (int i = 0; i < 10; i++) {
            System.out.println(Resource.i++);
        }
        System.out.println("End Increment Thread");
        lock.unlock();
    }
}
class Decrement implements Runnable {
    Lock lock;

    public Decrement(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("Start Decrement Thread");
        lock.lock();
        for (int i = 0; i < 10; i++) {
            System.out.println(Resource.i--);
        }
        System.out.println("End Decrement Thread");
        lock.unlock();
    }
}
