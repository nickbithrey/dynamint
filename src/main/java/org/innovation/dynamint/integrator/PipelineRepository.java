package org.innovation.dynamint.integrator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface PipelineRepository extends JpaRepository<Pipeline, Long> {

}
