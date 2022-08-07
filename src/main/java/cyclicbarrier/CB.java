package cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CB {
    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(3, new SomeAction());
        System.out.println("Запуск потоков");
        new Thread(new SomeThread(barrier, "1")).start();
        new Thread(new SomeThread(barrier, "2")).start();
        new Thread(new SomeThread(barrier, "3")).start();
        new Thread(new SomeThread(barrier, "4")).start();
        new Thread(new SomeThread(barrier, "5")).start();
        new Thread(new SomeThread(barrier, "6")).start();
    }
}
