package org.innovation.dynamint.compconfig;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@Table(name = "component_config")
public class ComponentConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String reference;

    @NotNull
    private String description;

    @NotNull
    private String componentType;

    @RestResource(exported = false)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "componentConfiguration")
    private Set<ComponentConfigurationAttribute> attributes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ComponentConfigurationAttribute> getAttributes() {
        return Collections.unmodifiableSet(attributes);
    }

    public boolean addAttribute(ComponentConfigurationAttribute a) {
        a.setComponentConfiguration(this);
        return attributes.add(a);
    }

    public boolean removeAttribute(ComponentConfigurationAttribute a) {
        a.setComponentConfiguration(null);
        return attributes.remove(a);
    }

    protected void setAttributes(Set<ComponentConfigurationAttribute> attributes) {
        this.attributes = attributes;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

}
