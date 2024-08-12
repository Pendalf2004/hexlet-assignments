package exercise;

import java.util.Map;

// BEGIN
class Tag {
    final Map<String, String> attributes;
    final String tagName;

    Tag(String name, Map<String, String> attr) {
        this.tagName = name;
        this.attributes = attr;
    }

    public String getAttributesStr() {
        String result = " ";
        for (var entry : attributes.entrySet()) {
            result += entry.getKey() + "=\"" + entry.getValue() + "\"";
        }
        return result;
    }
    public String getTagStr() {
        return "<" + this.tagName +  this.getAttributesStr() + ">";
    }
}
// END
