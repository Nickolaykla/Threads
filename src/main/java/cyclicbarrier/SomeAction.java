package cyclicbarrier;

public class SomeAction implements Runnable {
    @Override
    public void run() {
        System.out.println("Барьер достигнут");
    }
}
