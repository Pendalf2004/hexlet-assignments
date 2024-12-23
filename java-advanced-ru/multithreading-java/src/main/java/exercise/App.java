package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        MaxThread maxThread = new MaxThread(numbers);
        MinThread minThread = new MinThread(numbers);
        maxThread.run();
        minThread.run();
        var minMaxMap = new HashMap<String, Integer>();
        minMaxMap.put("min", minThread.getMinNum());
        minMaxMap.put("max", maxThread.getMaxNum());
        return minMaxMap;
    }
    // END
}
