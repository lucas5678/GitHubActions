package com.example.api.demo.Modelo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UserDto {
    private int id;
    private String usuario;
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;
}
