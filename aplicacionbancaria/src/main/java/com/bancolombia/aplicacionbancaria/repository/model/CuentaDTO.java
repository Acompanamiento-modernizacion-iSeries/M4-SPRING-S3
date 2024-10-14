package com.bancolombia.aplicacionbancaria.repository.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public class CuentaDTO {

    @NotNull(message = "Debe ingresar una cuenta valida")
    @NotEmpty(message = "Debe ingresar una cuenta valida")
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
