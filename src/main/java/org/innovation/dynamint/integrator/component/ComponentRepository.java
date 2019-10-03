package org.innovation.dynamint.integrator.component;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface ComponentRepository extends JpaRepository<Component, Long> {

}
