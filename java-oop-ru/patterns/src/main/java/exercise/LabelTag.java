package exercise;

// BEGIN
class LabelTag implements TagInterface {
    private final String textValue;
    private final TagInterface tag;

    LabelTag(String textValue, TagInterface tagObj) {
        this.textValue = textValue;
        this.tag = tagObj;
    }

    @Override
    public String render() {
        return "<label>" + textValue + tag.render() + "</label>";
    }
}
// END
