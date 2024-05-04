package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(InMemoryKV data) {
        var forDelete = data;
        data.toMap().forEach((key, value) -> {
            data.set(value, key);
        });
        forDelete.toMap().forEach((key, value) -> {
            data.unset(key);
        });
    }
}
// END
