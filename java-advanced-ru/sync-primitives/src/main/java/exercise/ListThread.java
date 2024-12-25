package exercise;

import java.util.Random;

// BEGIN
public class ListThread extends Thread{

    public ListThread(SafetyList list) {
        synchronized (this) {
            for (int i = 0; i < 1000; i++) {
                list.add((int) Math.floor(Math.random() * 20));
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
// END
