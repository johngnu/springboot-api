package com.heyma.service.core.model.repository.config;

import com.heyma.service.core.model.entity.config.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {

    Optional<Parameter> findByIdentifier(String identifier);
}
