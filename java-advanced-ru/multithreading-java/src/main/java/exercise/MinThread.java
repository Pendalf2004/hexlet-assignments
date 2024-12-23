package exercise;

import java.util.*;

// BEGIN
public class MinThread extends Thread {
    private int[] numArray;
    private int minNum;

    public MinThread(int[] array) {
        this.numArray = array;
    }

    @Override
    public void run() {
        minNum = Arrays.stream(numArray).min().getAsInt();
    }

    public int getMinNum() {
        return minNum;

    }
}
// END
