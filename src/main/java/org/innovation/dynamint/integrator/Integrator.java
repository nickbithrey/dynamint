package org.innovation.dynamint.integrator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder;

@Entity
@Table(name = "integrator")
public class Integrator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String reference;

    @NotNull
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonDeserialize(builder = BeanDeserializerBuilder.class)
    @RestResource(path = "integratorPipeline", rel = "pipeline")
    private Pipeline pipeline;

    @NotNull
    private IntegratorStatus status;

    private IntegratorRunningStatus runningStatus;

    protected Integrator() {
    }

    public Integrator(String reference, String description, IntegratorStatus status) {
        this.reference = reference;
        this.description = description;
        this.status = status;
    }

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

    public Pipeline getPipeline() {
        return pipeline;
    }

    public void setPipeline(Pipeline pipeline) {
        pipeline.setIntegrator(this);
        this.pipeline = pipeline;
    }

    public IntegratorStatus getStatus() {
        return status;
    }

    public void setStatus(IntegratorStatus status) {
        this.status = status;
    }

    public IntegratorRunningStatus getRunningStatus() {
        return runningStatus;
    }

    public void setRunningStatus(IntegratorRunningStatus runningStatus) {
        this.runningStatus = runningStatus;
    }

}
