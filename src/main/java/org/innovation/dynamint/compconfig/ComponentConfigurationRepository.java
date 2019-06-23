package org.innovation.dynamint.compconfig;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface ComponentConfigurationRepository extends JpaRepository<ComponentConfiguration, Long> {

    Optional<ComponentConfiguration> findByReference(String reference);

}
