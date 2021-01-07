package com.heyma.service.core.model.repository.config;

import com.heyma.service.core.model.entity.config.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}