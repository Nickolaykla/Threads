package exchanger;

import java.util.concurrent.Exchanger;

public class UseString implements Runnable {
    Exchanger<String> exchanger;
    String str;

    public UseString(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                str = exchanger.exchange("");
                System.out.println("Получено: " + str);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
