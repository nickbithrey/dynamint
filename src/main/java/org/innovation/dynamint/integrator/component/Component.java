package org.innovation.dynamint.integrator.component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.innovation.dynamint.compconfig.ComponentConfiguration;
import org.innovation.dynamint.integrator.BaseEntity;
import org.innovation.dynamint.integrator.Pipeline;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "component")
public class Component implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String reference;

    private String description;

    @RestResource(exported = true)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ComponentConfiguration componentConfiguration;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "component")
    private Set<Attribute> attributes = new HashSet<>();

    @NonNull
    @JsonIgnore
    @OneToOne(mappedBy = "component")
    private Pipeline pipeline;

    protected Component() {
    }

    public Component(String reference, String description, ComponentConfiguration modelComponent, Pipeline pipeline) {
        this.reference = reference;
        this.description = description;
        this.componentConfiguration = modelComponent;
        this.pipeline = pipeline;
    }

    @Override
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

    public ComponentConfiguration getComponentConfiguration() {
        return componentConfiguration;
    }

    public void setComponentConfiguration(ComponentConfiguration componentConfiguration) {
        this.componentConfiguration = componentConfiguration;
    }

    public Set<Attribute> getAttributes() {
        return Collections.unmodifiableSet(attributes);
    }

    public boolean addAttribute(Attribute a) {
        return this.attributes.add(a);
    }

    public boolean removeAttribute(Attribute a) {
        return this.attributes.remove(a);
    }

    protected void setAttributes(Set<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Pipeline getPipeline() {
        return pipeline;
    }

    public void setPipeline(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

}
