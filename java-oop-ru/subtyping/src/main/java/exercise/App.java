package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(inMemoryKV data) {
        var forDelete = data;
        data.forEach((key, value) -> {
            data.set(value, key);
        });
        forDelete.forEach((key) -> {
            data.unset(key);
        });
    }
}
// END
