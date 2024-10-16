package com.bancolombia.aplicacionbancaria.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

@Validated
public class CuentaDTO {

    @NotNull(message = "El número de cuenta no puede ser nulo...")
    @Positive(message = "El número de cuenta debe ser positivo...")
    @NotEmpty(message = "El número de cuenta no puede estar vacío...")
    private String numeroCuenta;

    public CuentaDTO(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public CuentaDTO() {
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
