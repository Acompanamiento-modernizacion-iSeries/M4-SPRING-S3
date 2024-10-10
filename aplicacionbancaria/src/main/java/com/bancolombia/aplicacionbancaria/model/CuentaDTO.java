package com.bancolombia.aplicacionbancaria.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public class CuentaDTO {

    @NotNull(message = "La cuenta no puede ser nula")
    @NotEmpty(message = "La cuenta no puede estar vacía")
    private String cuenta;

    public CuentaDTO(String cuenta) {
        this.cuenta =  cuenta;
    }

    public CuentaDTO() {
    }

    public String getCuenta() {
        return cuenta;
    }

}
