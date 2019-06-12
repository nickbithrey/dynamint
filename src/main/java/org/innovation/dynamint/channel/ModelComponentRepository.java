package org.innovation.dynamint.channel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface ModelComponentRepository extends JpaRepository<ModelComponent, Long> {

    Optional<ModelComponent> findByReference(String reference);

}
