package semaphore;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2);
        new Thread(new Philosopher(sem, "Сократ")).start();
        new Thread(new Philosopher(sem, "Платон")).start();
        new Thread(new Philosopher(sem, "Аристотель")).start();
        new Thread(new Philosopher(sem, "Пифагор")).start();
        new Thread(new Philosopher(sem, "Диоген")).start();
    }
}
