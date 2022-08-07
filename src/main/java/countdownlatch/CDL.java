package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CDL {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);

        System.out.println("Запуск потока исполнения");
        new Thread(new SomeThread(cdl)).start();

        try {
            cdl.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Завершение потока исполнения");
    }
}
