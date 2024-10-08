package com.bancolombia.sistemabancario.sistemabancario.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ConsultaSaldoDTO {

    @NotNull(message = "Debe ingresar el número de cuenta")
    @NotEmpty(message = "La cuenta no puede estar vacia")
    private String idCuenta;

    public ConsultaSaldoDTO() {
    }

    public ConsultaSaldoDTO(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }
}
