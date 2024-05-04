package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private static HashMap<String, String> data;

    public InMemoryKV(HashMap<String, String> inputData) {
        this.data = inputData;
    }
    public Map<String, String> toMap() {
        return this.data;
    }
    public void set(String key, String value) {
        this.data.put(key, value);
    }
    public void unset(String key) {
        this.data.remove(key);
    }
    public String get(String key, String defaultValue) {
        var result = this.data.containsKey(key) ? this.data.get(key) : defaultValue;
        return result;
    }

}
// END
