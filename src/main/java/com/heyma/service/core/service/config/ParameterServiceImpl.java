package com.heyma.service.core.service.config;

import com.heyma.service.core.controller.dto.ParameterDto;
import com.heyma.service.core.model.entity.config.Parameter;
import com.heyma.service.core.model.repository.config.ParameterRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    ParameterRepository parameterRepository;

    @Override
    public List<Parameter> findAll() {
        return parameterRepository.findAll();
    }

    @Override
    public Optional<Parameter> get(long id) {
        return parameterRepository.findById(id);
    }

    @Override
    public Optional<Parameter> findByIdentifier(String identifier) {
        return parameterRepository.findByIdentifier(identifier.trim());
    }

    @Override
    public Parameter persist(ParameterDto parameterDto) {
        Parameter parametro = new Parameter();
        BeanUtils.copyProperties(parameterDto, parametro);
        parameterRepository.save(parametro);
        return parametro;
    }

    @Override
    public void update(Parameter parameter, ParameterDto parameterDto) {
        BeanUtils.copyProperties(parameterDto, parameter);
        parameterRepository.save(parameter);
    }

    @Override
    public void delete(Parameter parameter) {
        parameterRepository.delete(parameter);
    }

}
