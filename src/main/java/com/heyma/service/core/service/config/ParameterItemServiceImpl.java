package com.heyma.service.core.service.config;

import com.heyma.service.core.controller.dto.ParameterItemDto;
import com.heyma.service.core.model.entity.config.Parameter;
import com.heyma.service.core.model.entity.config.ParameterItem;
import com.heyma.service.core.model.repository.config.ParameterItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParameterItemServiceImpl implements ParameterItemService {
    @Autowired
    ParameterItemRepository parameterItemRepository;

    @Override
    public List<ParameterItem> findAllByParameterId(long parameterId) {
        return parameterItemRepository.findAllByParameterId(parameterId);
    }

    @Override
    public Optional<ParameterItem> get(long id) {
        return parameterItemRepository.findById(id);
    }

    @Override
    public ParameterItem persist(Parameter parameter, ParameterItemDto parameterItemDto) {
        ParameterItem parameterItem = new ParameterItem();
        BeanUtils.copyProperties(parameterItemDto, parameterItem);
        parameterItem.setParameterId(parameter.getId());
        parameterItemRepository.save(parameterItem);
        return parameterItem;
    }

    @Override
    public void update(ParameterItem parameterItem, ParameterItemDto parameterItemDto) {
        BeanUtils.copyProperties(parameterItemDto, parameterItem);
        parameterItemRepository.save(parameterItem);
    }

    @Override
    public void delete(ParameterItem parameterItem) {
        parameterItemRepository.delete(parameterItem);
    }
}
