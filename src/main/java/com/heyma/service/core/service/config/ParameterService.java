package com.heyma.service.core.service.config;

import com.heyma.service.core.controller.dto.ParameterDto;
import com.heyma.service.core.model.entity.config.Parameter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ParameterService {

    @Transactional
    Parameter persist(ParameterDto parameterDto);

    @Transactional
    void update(Parameter parameter, ParameterDto parameterDto);

    @Transactional
    void delete(Parameter parameter);

    @Transactional(readOnly = true)
    Optional<Parameter> get(long id);

    @Transactional(readOnly = true)
    Optional<Parameter> findByIdentifier(String identifier);

    @Transactional(readOnly = true)
    List<Parameter> findAll();


}
