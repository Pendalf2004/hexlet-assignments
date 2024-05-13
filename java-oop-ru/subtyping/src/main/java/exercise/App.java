package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage data) {
        data.toMap().forEach((key, value) -> {
            data.set(value, key);
            data.unset(key);
        });
    }
}
// END
