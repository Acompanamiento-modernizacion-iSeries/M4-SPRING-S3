package com.bancolombia.aplicacionbancaria.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Validated
public class TransaccionDTO {

    @NotNull(message = "La cuenta no puede ser nula")
    @NotEmpty(message = "La cuenta no puede estar vacía")
    private String cuenta;
    @NotNull(message = "El monto no puede ser nulo")
    @Positive(message = "El monto debe ser mayor a cero")
    private BigDecimal monto;
    @NotNull(message = "La descripción no puede ser nula")
    private String descripcion;
    public TransaccionDTO(BigDecimal monto, String descripcion, String cuenta) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.cuenta =  cuenta;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCuenta() {
        return cuenta;
    }
}
