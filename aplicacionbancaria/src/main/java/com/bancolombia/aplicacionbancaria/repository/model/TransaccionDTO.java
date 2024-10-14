package com.bancolombia.aplicacionbancaria.repository.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Validated
public class TransaccionDTO {

    @NotNull(message = "Debe ingresar una cuenta valida")
    @NotEmpty(message = "Debe ingresar una cuenta valida")
    private String cuenta;
    @NotNull(message = "Ingrese un monto valido")
    @Positive(message = "Ingrese un monto mayor a cero")
    private BigDecimal monto;
    @NotNull(message = "Ingrese una descripción valida")
    private final String descripcion;
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
