package org.innovation.dynamint.compconfig;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = true)
public interface ComponentConfigurationAttributeRepository
        extends JpaRepository<ComponentConfigurationAttribute, Long> {

}
