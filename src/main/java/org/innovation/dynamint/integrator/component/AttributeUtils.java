package org.innovation.dynamint.integrator.component;

import org.innovation.dynamint.compconfig.ComponentConfigurationAttribute;

public class AttributeUtils {

    private AttributeUtils() {
    }

    public static final Attribute createAttr(Component c, ComponentConfigurationAttribute modelAttribute, Object value) {
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
