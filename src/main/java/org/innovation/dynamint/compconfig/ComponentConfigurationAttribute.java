package org.innovation.dynamint.compconfig;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "config_attribute")
public class ComponentConfigurationAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Class<?> type;

    private boolean required;

    private String defaultValue;

    private boolean pathParameter;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private ComponentConfiguration componentConfiguration;

    protected ComponentConfigurationAttribute() {
    }

    public ComponentConfigurationAttribute(String name, Class<?> type, boolean pathParameter) {
        this.name = name;
        this.type = type;
        this.pathParameter = pathParameter;
        this.required = pathParameter;
    }

    public ComponentConfigurationAttribute(String name, Class<?> type, String defaultValue, boolean pathParameter) {
        this.name = name;
        this.type = type;
        this.defaultValue = defaultValue;
        this.pathParameter = pathParameter;
        this.required = pathParameter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public boolean isPathParameter() {
        return pathParameter;
    }

    public void setPathParameter(boolean pathParameter) {
        this.pathParameter = pathParameter;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public ComponentConfiguration getComponentConfiguration() {
        return componentConfiguration;
    }

    public void setComponentConfiguration(ComponentConfiguration componentConfiguration) {
        this.componentConfiguration = componentConfiguration;
    }

}
