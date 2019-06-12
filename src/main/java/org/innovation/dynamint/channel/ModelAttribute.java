package org.innovation.dynamint.channel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "modelAttribute")
public class ModelAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Class<?> type;

    private boolean pathParameter;

    protected ModelAttribute() {
    }

    public ModelAttribute(String name, Class<?> type, boolean pathParameter) {
        this.name = name;
        this.type = type;
        this.pathParameter = pathParameter;
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

}
