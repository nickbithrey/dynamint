package org.innovation.dynamint.integrator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.innovation.dynamint.integrator.component.Component;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "pipeline")
public class Pipeline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonInclude(Include.NON_NULL)
    @OneToOne(cascade = CascadeType.ALL)
    private Pipeline next;

    @OneToOne(cascade = CascadeType.ALL)
    private Component component;

    @NonNull
    @JsonIgnore
    @OneToOne(mappedBy = "pipeline")
    private Integrator integrator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pipeline getNext() {
        return next;
    }

    public void setNext(Pipeline next) {
        this.next = next;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Integrator getIntegrator() {
        return integrator;
    }

    public void setIntegrator(Integrator integrator) {
        this.integrator = integrator;
    }

}
