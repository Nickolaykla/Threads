package exchanger;

import java.util.concurrent.Exchanger;

public class MakeString implements Runnable {
    Exchanger<String> exchanger;
    String str;

    public MakeString(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        str = "";
    }

    @Override
    public void run() {
        char ch = 'A';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                str += (char) ch++;
            }

            try {
                str = exchanger.exchange(str);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
