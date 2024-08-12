package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    private final String body;
    private final List<SingleTag> child;

    PairedTag (String tag, Map<String, String> attr, String body, List<SingleTag> childList) {
        super(tag, attr);
        this.body = body;
        this.child = childList;
    }
    @Override
    public String toString() {
        String result = "<" + this.tagName;
        for (var atr : child) {
            result += child.toString();
        }
        result +=">" + this.body + "</" + this.tagName + ">";
        return result;
    }
}
// END
