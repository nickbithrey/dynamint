package org.innovation.dynamint.channel;

public class AttributeUtils {

    private AttributeUtils() {
    }

    public static final Attribute createAttr(Component c, ModelAttribute modelAttribute, Object value) {
        Attribute a = new Attribute(modelAttribute, c);
        setAttrValue(a, value);
        return a;
    }

    public static final void setAttrValue(Attribute a, Object value) {
        if (value != null) {
            a.setValue(value.toString());
        } else {
            a.setValue(null);
        }
    }

}
