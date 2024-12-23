package exercise;

// BEGIN

import java.util.*;

public class MaxThread extends Thread {
    private int[] numArray;
    private int maxNum;

    public MaxThread(int[] array) {
        this.numArray = array;
    }

    @Override
    public void run() {
        maxNum = Arrays.stream(numArray).max().getAsInt();
    }

    public int getMaxNum() {
        return maxNum;

    }
}
// END
