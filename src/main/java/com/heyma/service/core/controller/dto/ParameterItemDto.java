package com.heyma.service.core.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParameterItemDto {
    private Integer approved;
    private String identifier;
    private String description;
    private Integer order;
    private boolean enabled;
}
