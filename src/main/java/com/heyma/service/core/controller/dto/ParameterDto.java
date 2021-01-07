package com.heyma.service.core.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParameterDto {
    private String identifier;
    private String description;
    private boolean enabled;
}
