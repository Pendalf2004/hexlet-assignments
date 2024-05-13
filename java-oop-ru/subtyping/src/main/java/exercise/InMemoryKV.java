package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> data;

    public InMemoryKV(Map<String, String> inputData) {
        data = new HashMap<>(inputData);
    }

    public Map<String, String> toMap() {
        return new HashMap<>(data);
    }

    public void set(String key, String value) {
        Map<String, String> tmp = new HashMap<>(data);
        tmp.put(key, value);
        data = tmp;
    }

    public void unset(String key) {
        Map<String, String> tmp = new HashMap<>(data);
        tmp.remove(key);
        data = tmp;
    }

    public String get(String key, String defaultValue) {
        return data.containsKey(key) ? data.get(key) : defaultValue;
    }
}
// END
