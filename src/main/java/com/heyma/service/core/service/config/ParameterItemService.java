package com.heyma.service.core.service.config;

import com.heyma.service.core.controller.dto.ParameterItemDto;
import com.heyma.service.core.model.entity.config.Parameter;
import com.heyma.service.core.model.entity.config.ParameterItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ParameterItemService {

    @Transactional(readOnly = true)
    List<ParameterItem> findAllByParameterId(long parameterId);

    @Transactional(readOnly = true)
    Optional<ParameterItem> get(long id);

    @Transactional
    ParameterItem persist(Parameter parameter, ParameterItemDto parameterItemDto);

    @Transactional
    void update(ParameterItem parameterItem, ParameterItemDto parameterItemDto);

    @Transactional
    void delete(ParameterItem parameterItem);
}
