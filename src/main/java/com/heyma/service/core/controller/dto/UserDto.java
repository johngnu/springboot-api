package com.heyma.service.core.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDto {
    private String username;
    private String password;
    private String completeName;
    private String email;
    private Date birthdate;
    private String address;
    private Boolean enabled;

}
