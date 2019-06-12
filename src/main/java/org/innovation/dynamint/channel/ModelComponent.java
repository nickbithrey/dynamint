package org.innovation.dynamint.channel;

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

@Entity
@Table(name = "model_component")
public class ModelComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String reference;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ModelAttribute> attributes = new HashSet<>();

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

    public Set<ModelAttribute> getAttributes() {
        return Collections.unmodifiableSet(attributes);
    }

    public boolean addAttribute(ModelAttribute a) {
        return attributes.add(a);
    }

    public boolean removeAttribute(ModelAttribute a) {
        return attributes.remove(a);
    }

    protected void setAttributes(Set<ModelAttribute> attributes) {
        this.attributes = attributes;
    }

}
