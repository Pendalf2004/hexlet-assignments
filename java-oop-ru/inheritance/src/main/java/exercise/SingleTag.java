package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {

    SingleTag(String name, Map<String, String> attr) {
        super(name, attr);
    }

    @Override
    public String toString() {
        return this.getAttributesStr();
    }
}
// END
