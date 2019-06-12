package org.innovation.dynamint.channel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder;

@Entity
@Table(name = "integrator")
public class Integrator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String reference;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonDeserialize(builder = BeanDeserializerBuilder.class)
    @RestResource(path = "integratorPipeline", rel = "pipeline")
    private Pipeline pipeline;

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

    public Pipeline getPipeline() {
        return pipeline;
    }

    public void setPipeline(Pipeline pipeline) {
        pipeline.setIntegrator(this);
        this.pipeline = pipeline;
    }

}
