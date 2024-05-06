package exercise;

import java.util.Map;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private static Map<String, String> data;

    public InMemoryKV(Map<String, String> inputData) {
        data = inputData;
    }

    public Map<String, String> toMap() {
        return data;
    }

    public void set(String key, String value) {
        data.put(key, value);
    }

    public void unset(String key) {
        data.remove(key);
    }

    public String get(String key, String defaultValue) {
        return data.containsKey(key) ? data.get(key) : defaultValue;
    }
}
// END
