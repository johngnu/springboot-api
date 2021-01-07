package com.heyma.service.core.model.repository.config;

import com.heyma.service.core.model.entity.config.ParameterItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParameterItemRepository extends JpaRepository<ParameterItem, Long> {

    List<ParameterItem> findAllByParameterId(long parameterId);
}
