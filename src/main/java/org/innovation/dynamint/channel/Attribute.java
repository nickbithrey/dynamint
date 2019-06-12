package org.innovation.dynamint.channel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "attribute")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ModelAttribute modelAttribute;

    private String value;

    @NonNull
    @ManyToOne(optional = false)
    private Component component;

    protected Attribute() {
    }

    public Attribute(ModelAttribute modelAttribute, Component component) {
        this.modelAttribute = modelAttribute;
        this.component = component;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ModelAttribute getModelAttribute() {
        return modelAttribute;
    }

    public void setModelAttribute(ModelAttribute modelAttribute) {
        this.modelAttribute = modelAttribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

}
