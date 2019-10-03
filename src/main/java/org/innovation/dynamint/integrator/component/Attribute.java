package org.innovation.dynamint.integrator.component;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.innovation.dynamint.compconfig.ComponentConfigurationAttribute;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "attribute")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ComponentConfigurationAttribute configurationAttribute;

    private String value;

    @NonNull
    @JsonIgnore
    @ManyToOne(optional = false)
    private Component component;

    protected Attribute() {
    }

    public Attribute(ComponentConfigurationAttribute configurationAttribute, Component component) {
        this.configurationAttribute = configurationAttribute;
        this.component = component;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ComponentConfigurationAttribute getConfigurationAttribute() {
        return configurationAttribute;
    }

    public void setConfigurationAttribute(ComponentConfigurationAttribute configurationAttribute) {
        this.configurationAttribute = configurationAttribute;
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
