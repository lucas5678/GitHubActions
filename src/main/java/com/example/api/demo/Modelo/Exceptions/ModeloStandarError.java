package com.example.api.demo.Modelo.Exceptions;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ModeloStandarError {
    
    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String path;
}
